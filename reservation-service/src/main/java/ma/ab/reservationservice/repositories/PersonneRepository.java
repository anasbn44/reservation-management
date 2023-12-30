package ma.ab.reservationservice.repositories;

import ma.ab.reservationservice.entities.Personne;
import ma.ab.reservationservice.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepository extends JpaRepository<Personne, Long> {
}
