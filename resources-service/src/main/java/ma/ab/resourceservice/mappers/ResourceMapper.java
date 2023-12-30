package ma.ab.resourceservice.mappers;

import ma.ab.resourceservice.dtos.ResourceRequestDto;
import ma.ab.resourceservice.dtos.ResourceResponseDto;
import ma.ab.resourceservice.entities.Resource;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ResourceMapper {
    private ModelMapper modelMapper = new ModelMapper();

    public ResourceResponseDto from(Resource resource){
        return modelMapper.map(resource, ResourceResponseDto.class);
    }

    public Resource to(ResourceRequestDto resourceRequestDto){
        return modelMapper.map(resourceRequestDto, Resource.class);
    }
}
