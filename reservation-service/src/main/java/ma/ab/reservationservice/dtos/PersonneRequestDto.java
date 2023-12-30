package ma.ab.reservationservice.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import ma.ab.reservationservice.entities.Reservation;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonneRequestDto {
    private String nom;
    private String email;
    private String fonction;

}
