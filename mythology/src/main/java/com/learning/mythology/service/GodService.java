package com.learning.mythology.service;

import com.learning.mythology.model.God;

import java.util.List;

public interface GodService {

    God createGod(God god);

    List<God> getGods();

}
