package ma.ab.resourceservice.services;

import ma.ab.resourceservice.dtos.ResourceResponseDto;

import java.util.List;

public interface ResourceService {
    List<ResourceResponseDto> getAll();
    ResourceResponseDto getbyId(Long id);
}
