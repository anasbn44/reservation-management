package ma.ab.reservationservice.service;

import ma.ab.reservationservice.dtos.PersonneResponseDto;
import ma.ab.reservationservice.entities.Personne;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PersonneService {
    List<PersonneResponseDto> getPersonnes();
    PersonneResponseDto getPersonneById(Long id);
}
