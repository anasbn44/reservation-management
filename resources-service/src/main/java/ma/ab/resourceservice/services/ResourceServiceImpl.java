package ma.ab.resourceservice.services;

import ma.ab.resourceservice.dtos.ResourceResponseDto;
import ma.ab.resourceservice.entities.Resource;
import ma.ab.resourceservice.mappers.ResourceMapper;
import ma.ab.resourceservice.repositories.ResourceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResourceServiceImpl implements ResourceService {
    private ResourceRepository resourceRepository;
    private ResourceMapper resourceMapper;

    public ResourceServiceImpl(ResourceRepository resourceRepository, ResourceMapper keynoteMapper) {
        this.resourceRepository = resourceRepository;
        this.resourceMapper = keynoteMapper;
    }

    @Override
    public List<ResourceResponseDto> getAll() {
        List<Resource> resources = resourceRepository.findAll();
        return resources.stream().map(resourceMapper::from).collect(Collectors.toList());
    }

    @Override
    public ResourceResponseDto getbyId(Long id) {
        Resource resource = resourceRepository.findById(id).orElse(null);
        if (resource == null) throw new RuntimeException(String.format("resource by Id : %d is not found", id));
        return resourceMapper.from(resource);
    }
}
