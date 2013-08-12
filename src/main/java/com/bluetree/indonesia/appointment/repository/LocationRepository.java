package com.bluetree.indonesia.appointment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.bluetree.indonesia.appointment.domain.Location;

public interface LocationRepository extends JpaRepository<Location, Long>, JpaSpecificationExecutor<Location> {
	
    List<Location> findByTopicsTextAndZipCode(String text, String zipCode);
    
    List<Location> findByTopicsTextAndCity(String text, String city);
    
    List<Location> findByTopicsTextAndZipCodeAndCity(String text, String zipCode, String city);
}
