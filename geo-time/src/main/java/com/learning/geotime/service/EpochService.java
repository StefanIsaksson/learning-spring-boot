package com.learning.geotime.service;

import com.learning.geotime.model.Epoch;

import java.util.List;

public interface EpochService {

    void createEpoch(Epoch epoch);

    List<Epoch> getEpochs();

}
