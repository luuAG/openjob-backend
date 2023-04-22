package com.openjob.service;

import com.openjob.model.entity.Location;
import com.openjob.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocationService extends BaseService<Location, ObjectId> {
    private final LocationRepository locationRepository;
    private final MongoTemplate mongoTemplate;

    @Override
    protected void init() {
        repository = this.locationRepository;
        baseMongoTemplate = this.mongoTemplate;
        clazz = Location.class;
    }
}
