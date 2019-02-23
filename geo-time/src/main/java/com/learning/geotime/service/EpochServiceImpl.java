package com.learning.geotime.service;

import com.learning.geotime.model.Epoch;
import com.learning.geotime.repository.EpochRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpochServiceImpl implements EpochService {

    @Autowired
    EpochRepository epochRepository;

    @Override
    public void createEpoch(Epoch epoch) {
        epochRepository.createEpoch(epoch);
    }

    @Override
    public List<Epoch> getEpochs() {
        return epochRepository.getEpochs();
    }
}
