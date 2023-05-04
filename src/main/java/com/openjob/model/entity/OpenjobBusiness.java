package com.openjob.model.entity;

import com.openjob.model.entity.base.IdentifierEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("openjob-business")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OpenjobBusiness extends IdentifierEntity {
    private Integer freeJob;
    private Integer maxTimeForFreeJobInDays;

    private Integer freeCvView;

    private Double baseJobPricePerDay;
    private Double baseCvViewPrice;
    private Double internWeight;
    private Double fresherWeight;
    private Double juniorWeight;
    private Double middleWeight;
    private Double seniorWeight;
    private Double highPositionWeight;

    // premium
    private Integer premiumFreeJob;
    private Integer premiumFreeViewCv;




}
