package ma.ab.reservationservice.web;

import ma.ab.reservationservice.dtos.PersonneResponseDto;
import ma.ab.reservationservice.dtos.ReservationResponseDto;
import ma.ab.reservationservice.entities.Reservation;
import ma.ab.reservationservice.mappers.PersonneMapper;
import ma.ab.reservationservice.model.Resource;
import ma.ab.reservationservice.service.PersonneService;
import ma.ab.reservationservice.service.ReservationService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.util.List;

@RestController
public class ReservationRestController {
    private PersonneService personneService;
    private ReservationService reservationService;
    private PersonneMapper personneMapper;

    public ReservationRestController(PersonneService personneService, ReservationService reservationService, PersonneMapper personneMapper) {
        this.personneService = personneService;
        this.reservationService = reservationService;
        this.personneMapper = personneMapper;
    }

    @GetMapping("/Reservations")
    public List<Reservation> getAllReservations(){
        return reservationService.getReservations();
    }

    @GetMapping("/Reservations/{id}")
    public Reservation getReservation(@PathVariable Long id){
        return reservationService.getReservationById(id);
    }

    @GetMapping("/Personnes")
    public List<PersonneResponseDto> getAllPersonnes(){
        return personneService.getPersonnes();
    }
}
