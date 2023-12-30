package ma.ab.reservationservice.dtos;

import jakarta.persistence.*;
import lombok.*;
import ma.ab.reservationservice.entities.Personne;
import ma.ab.reservationservice.model.Resource;

import java.util.Date;
import java.util.List;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class ReservationResponseDto {
    private Long id;
    private String nom;
    private String contexte;
    private Date date;
    private Long duree;
    private Long idPersonne;
    private Long resourceId;
    private Resource resource;
    private Personne personne;
}
