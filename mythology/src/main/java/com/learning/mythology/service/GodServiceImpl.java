package com.learning.mythology.service;

import com.learning.mythology.model.God;
import com.learning.mythology.repository.GodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GodServiceImpl implements GodService{

    @Autowired
    private GodRepository godRepository;

    @Override
    public God createGod(God god) {
        return godRepository.createGod(god);
    }

    @Override
    public List<God> getGods() {
        return godRepository.getGods();
    }

    @Override
    public God getGod(Integer id) {
        return godRepository.getGod(id);
    }

    @Override
    public God updateGod(God god) {
        return godRepository.updateGod(god);
    }

    @Override
    public void deleteGod(Integer id) {
        godRepository.deleteGod(id);
    }
}
