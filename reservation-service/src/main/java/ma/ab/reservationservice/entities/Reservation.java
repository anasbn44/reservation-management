package ma.ab.reservationservice.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.ab.reservationservice.model.Resource;

import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class Reservation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String contexte;
    private Date date;
    private Long duree;
    private Long idPersonne;
    private Long resourceId;
    @Transient
    private Resource resource;
    @ManyToOne
    private Personne personne;
}
