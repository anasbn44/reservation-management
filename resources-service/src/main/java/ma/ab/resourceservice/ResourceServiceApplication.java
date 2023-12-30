package ma.ab.resourceservice;

import ma.ab.resourceservice.entities.Resource;
import ma.ab.resourceservice.enums.Type;
import ma.ab.resourceservice.repositories.ResourceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ResourceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResourceServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ResourceRepository resourceRepository){
		return args -> {
			resourceRepository.saveAll(List.of(
					Resource.builder().nom("canon").type(Type.MATERIEL_AUDIO_VUSUEL).build(),
					Resource.builder().nom("hp").type(Type.MATERIEL_INF0).build(),
					Resource.builder().nom("sony").type(Type.MATERIEL_AUDIO_VUSUEL).build()
			));
		};
	}
}
