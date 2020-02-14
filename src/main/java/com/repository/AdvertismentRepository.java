package com.repository;

import com.model.Advertisment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdvertismentRepository extends CrudRepository<Advertisment, Long> {

    List<Advertisment> findAdvertismentsByCity(String city);

    Advertisment findAdvertismentById(Long id);


}
