package com.openjob.service;

import com.openjob.model.entity.Province;
import com.openjob.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LocationService extends BaseService<Province, String> {
    private final LocationRepository locationRepository;
    private final MongoTemplate mongoTemplate;

    @Override
    protected void init() {
        repository = this.locationRepository;
        baseMongoTemplate = this.mongoTemplate;
        clazz = Province.class;
    }

    public List<String> getProvinces() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.project("name")
        );

        AggregationResults<Document> results = mongoTemplate.aggregate(aggregation, "locations", Document.class);
        return results.getMappedResults()
                .stream()
                .map(document -> document.getString("name"))
                .collect(Collectors.toList());
    }

    public List<String> getDistrictsByProvinceName(String province) {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("name").is(province)),
                Aggregation.unwind("districts"),
                Aggregation.project("districts.name")
        );

        AggregationResults<Document> results = mongoTemplate.aggregate(aggregation, "locations", Document.class);
        return results.getMappedResults()
                .stream()
                .map(document -> document.getString("name"))
                .collect(Collectors.toList());
    }

    public List<String> getWardsByProvinceAndDistrict(String province, String district) {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("name").is(province)),
                Aggregation.unwind("districts"),
                Aggregation.match(Criteria.where("districts.name").is(district)),
                Aggregation.project("districts.wards.name")
        );

        AggregationResults<Document> results = mongoTemplate.aggregate(aggregation, "locations", Document.class);
        return (List<String>) results.getMappedResults().get(0).get("wards", Map.class).get("name");
    }
}
