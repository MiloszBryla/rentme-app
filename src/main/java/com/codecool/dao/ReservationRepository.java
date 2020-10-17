package com.codecool.dao;

import com.codecool.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReservationRepository  extends JpaRepository<Reservation, Long> {

    Reservation getReservationById(Long id);

    @Query("select r from Reservation r left join r.owner o where r.owner.id = :id")
    List<Reservation> getReservationsByOwnerId(Long id);


}