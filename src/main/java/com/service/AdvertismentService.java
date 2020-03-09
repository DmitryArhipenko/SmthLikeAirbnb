package com.service;

import com.model.Advertisment;
import com.model.ApartmentType;
import com.repository.AdvertismentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertismentService {

    @Autowired
    private AdvertismentRepository advertismentRepository;

    public void save(Advertisment advertisment) {
        advertismentRepository.save(advertisment);
    }

    public List<Advertisment> listAll() {
        return (List<Advertisment>) advertismentRepository.findAll();
    }

    public Advertisment get(Long id) {
        return advertismentRepository.findById(id).get();
    }

    public void delete(Long id) {
        advertismentRepository.deleteById(id);
    }

    public void update(Advertisment advertisment) {
        advertismentRepository.save(advertisment);
    }

    public List<Advertisment> listByTheCity(String city) {
        return advertismentRepository.findAdvertismentsByCity(city);
    }

    public Advertisment findAdvertismentById(Long id) {
        return advertismentRepository.findAdvertismentById(id);
    }

    public Advertisment findAdvertismentByTitle(String title) {
        return advertismentRepository.findAdvertismentByTitle(title);
    }

    public List<Advertisment> findAdvertismentsByApartment_type (String apartmentType){
        return advertismentRepository.findAdvertismentsByApartment_type(apartmentType);
    }
}