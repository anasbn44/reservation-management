package ma.ab.resourceservice.dtos;

import lombok.*;
import ma.ab.resourceservice.enums.Type;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class ResourceResponseDto {
    private Long id;
    private String nom;
    private Type type;
}
