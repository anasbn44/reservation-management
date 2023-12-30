package ma.ab.reservationservice.mappers;

import ma.ab.reservationservice.dtos.ReservationRequestDto;
import ma.ab.reservationservice.dtos.ReservationResponseDto;
import ma.ab.reservationservice.entities.Reservation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {
    private ModelMapper modelMapper = new ModelMapper();

    public ReservationResponseDto from(Reservation reservation){
        return modelMapper.map(reservation, ReservationResponseDto.class);
    }

    public Reservation to(ReservationRequestDto reservationRequestDto){
        return modelMapper.map(reservationRequestDto, Reservation.class);
    }
}
