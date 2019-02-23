package com.learning.geotime.repository;

import com.learning.geotime.model.Epoch;

import java.util.List;

public interface EpochRepository {

    void createEpoch(Epoch epoch);

    List<Epoch> getEpochs();
}
