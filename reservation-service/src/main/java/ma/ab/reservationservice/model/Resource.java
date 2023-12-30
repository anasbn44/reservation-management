package ma.ab.reservationservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import ma.ab.reservationservice.enums.Type;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class Resource {
    private Long id;
    private String nom;
    private Type type;
}
