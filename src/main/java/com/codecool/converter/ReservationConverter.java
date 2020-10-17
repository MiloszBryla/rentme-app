package com.codecool.converter;

import com.codecool.model.Reservation;
import com.codecool.modelDTO.ReservationDTO;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReservationConverter {

    public static List<ReservationDTO> entitiesToDTO(List<Reservation> reservations) {
        return reservations.stream()
                .map(reservation -> entityToDTO(reservation))
                .collect(Collectors.toList());
    }

    public static ReservationDTO entityToDTO(Reservation reservation) {
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setId(reservation.getId());
        reservationDTO.setItem(reservation.getItem());
        reservationDTO.setOwner(reservation.getOwner());
        reservationDTO.setDateStart(reservation.getDateStart());
        reservationDTO.setDateEnd(reservation.getDateEnd());

        return reservationDTO;
    }

    public static Reservation DTOToEntity(ReservationDTO reservationDTO) {
        Reservation reservation = new Reservation();
        reservation.setId(reservationDTO.getId());
        reservation.setItem(reservationDTO.getItem());
        reservation.setOwner(reservationDTO.getOwner());
        reservation.setDateStart(reservationDTO.getDateStart());
        reservation.setDateEnd(reservationDTO.getDateEnd());

        return reservation;
    }


}
