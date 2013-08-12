package com.bluetree.indonesia.appointment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.bluetree.indonesia.appointment.domain.City;

public interface CityRepository extends JpaRepository<City, Long>, JpaSpecificationExecutor<City> {
	
    List<City> findByNameStartingWith(String nameFragment);
}
