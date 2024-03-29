package com.openjob.service;

import com.openjob.model.entity.OpenjobBusiness;
import com.openjob.repository.OpenjobBusinessRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OpenjobBusinessService {
    private final OpenjobBusinessRepository repository;

    public OpenjobBusiness get(){
        return repository.findAll().get(0);
    }

    public OpenjobBusiness update(OpenjobBusiness openjobBusiness){
        OpenjobBusiness data = get();

        data.setMaxTimeForFreeJobInDays(openjobBusiness.getMaxTimeForFreeJobInDays());

        data.setBaseJobPricePerDay(openjobBusiness.getBaseJobPricePerDay());
        data.setBaseCvViewPrice(openjobBusiness.getBaseCvViewPrice());

        data.setFreeCvView(openjobBusiness.getFreeCvView());
        data.setFreeJob(openjobBusiness.getFreeJob());

        data.setFresherWeight(openjobBusiness.getFresherWeight());
        data.setInternWeight(openjobBusiness.getInternWeight());
        data.setJuniorWeight(openjobBusiness.getJuniorWeight());
        data.setMiddleWeight(openjobBusiness.getMiddleWeight());
        data.setSeniorWeight(openjobBusiness.getSeniorWeight());
        data.setHighPositionWeight(openjobBusiness.getHighPositionWeight());

        data.setPremiumFreeViewCv(openjobBusiness.getPremiumFreeViewCv());
        data.setPremiumFreeJob(openjobBusiness.getPremiumFreeJob());

        return repository.save(data);
    }
}
