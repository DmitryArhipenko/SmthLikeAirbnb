package com.service;

import com.model.Reservation;
import com.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public void save(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    public List<Reservation> listAll() {
        return (List<Reservation>) reservationRepository.findAll();
    }

    public Reservation get(Long id) {
        return reservationRepository.findById(id).get();
    }

    public void delete(Long id) {
        reservationRepository.deleteById(id);
    }

    public void update(Reservation reservation) {
        reservationRepository.save(reservation);
    }

}
