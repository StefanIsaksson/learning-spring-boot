package com.science.geology.repository;

import com.science.geology.model.Rock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RockRepository extends JpaRepository<Rock, Long> {
}
