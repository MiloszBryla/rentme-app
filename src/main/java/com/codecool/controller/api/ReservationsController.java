package com.codecool.controller.api;

import com.codecool.converter.AppUserConverter;
import com.codecool.converter.ReservationConverter;
import com.codecool.model.Reservation;
import com.codecool.modelDTO.AppUserDTO;
import com.codecool.modelDTO.ReservationDTO;
import com.codecool.service.ReservationService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.HttpStatus.CREATED;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/reservations")
public class ReservationsController {

    private ReservationService reservationService;

    public ReservationsController(ReservationService reservationService){
        this.reservationService = reservationService;
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public List<ReservationDTO> getAllReservations(){
        return ReservationConverter.entitiesToDTO(reservationService.getAllReservations());
    }

    @GetMapping(params = "ownerId", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(OK)
    public List<ReservationDTO> getReservationsByOwner(@RequestParam(value="ownerId") Long ownerId){
        return ReservationConverter.entitiesToDTO(reservationService.getReservationsByOwnerId(ownerId));
    }

    @PostMapping()
    @ResponseBody
    @ResponseStatus(CREATED)
    public ResponseEntity<Object> attemptToAddReservation(@RequestBody ReservationDTO reservationDTO) {
            reservationService.addReservation(ReservationConverter.DTOToEntity(reservationDTO));
            return ResponseEntity.status(CREATED).body("Account has been created.");
        }

}
