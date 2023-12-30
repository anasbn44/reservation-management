package ma.ab.reservationservice.service;

import ma.ab.reservationservice.dtos.ReservationResponseDto;
import ma.ab.reservationservice.entities.Reservation;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ReservationService {
    List<Reservation> getReservations();
    Reservation getReservationById(Long id);
}
