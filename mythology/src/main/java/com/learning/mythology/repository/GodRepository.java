package com.learning.mythology.repository;

import com.learning.mythology.model.God;

import java.util.List;

public interface GodRepository {

    List<God> getGods();

    God createGod(God god);

    God getGod(Integer id);

    God updateGod(God god);

    void deleteGod(Integer id);
}
