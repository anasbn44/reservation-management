package ma.ab.reservationservice.mappers;

import ma.ab.reservationservice.dtos.PersonneRequestDto;
import ma.ab.reservationservice.dtos.PersonneResponseDto;
import ma.ab.reservationservice.dtos.ReservationRequestDto;
import ma.ab.reservationservice.dtos.ReservationResponseDto;
import ma.ab.reservationservice.entities.Personne;
import ma.ab.reservationservice.entities.Reservation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PersonneMapper {
    private ModelMapper modelMapper = new ModelMapper();

    public PersonneResponseDto from(Personne personne){
        return modelMapper.map(personne, PersonneResponseDto.class);
    }

    public Personne to(PersonneResponseDto personneResponseDto){
        return modelMapper.map(personneResponseDto, Personne.class);
    }
}
