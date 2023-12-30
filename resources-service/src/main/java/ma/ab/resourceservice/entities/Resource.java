package ma.ab.resourceservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import ma.ab.resourceservice.enums.Type;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class Resource {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private Type type;
}
