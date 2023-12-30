package ma.ab.resourceservice.web;

import ma.ab.resourceservice.dtos.ResourceResponseDto;
import ma.ab.resourceservice.services.ResourceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ResourceRestController {
    private ResourceService resourceService;


    public ResourceRestController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @GetMapping("/Resources")
    public List<ResourceResponseDto> getAllResources(){
        return resourceService.getAll();
    }

    @GetMapping("/Resources/{id}")
    public ResourceResponseDto getResourceById(@PathVariable Long id){
        return resourceService.getbyId(id);
    }
}
