package com.codecool.service;

import com.codecool.dao.ReservationRepository;
import com.codecool.model.Reservation;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReservationService {
    private ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository){
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getAllReservations(){

        return reservationRepository.findAll();
    }

    public Reservation findById(Long id){

        return reservationRepository.getReservationById(id);
    }

    public void addReservation(Reservation reservation){

        reservationRepository.save(reservation);
    }

    public void updateReservation(Reservation reservation){

        reservationRepository.save(reservation);
    }

    public void deleteReservationById(Long id){

        reservationRepository.deleteById(id);
    }

    public List<Reservation> getReservationsByOwnerId(Long ownerId){

        return reservationRepository.getReservationsByOwnerId(ownerId);
    }


}
