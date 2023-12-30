package ma.ab.resourceservice.repositories;

import ma.ab.resourceservice.entities.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
}
