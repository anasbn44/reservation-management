package ma.ab.reservationservice.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import ma.ab.reservationservice.entities.Reservation;
import org.apache.catalina.LifecycleState;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonneResponseDto {
    private Long id;
    private String nom;
    private String email;
    private String fonction;
    private List<Reservation> reservations;
}
