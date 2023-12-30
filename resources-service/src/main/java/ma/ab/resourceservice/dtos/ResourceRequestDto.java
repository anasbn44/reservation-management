package ma.ab.resourceservice.dtos;

import lombok.*;
import ma.ab.resourceservice.enums.Type;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class ResourceRequestDto {
    private String nom;
    private Type type;
}
