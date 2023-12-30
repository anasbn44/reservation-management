package ma.ab.reservationservice;

import ma.ab.reservationservice.entities.Personne;
import ma.ab.reservationservice.entities.Reservation;
import ma.ab.reservationservice.repositories.PersonneRepository;
import ma.ab.reservationservice.repositories.ReservationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class ReservationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReservationServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(ReservationRepository reservationRepository, PersonneRepository personneRepository){
        return args -> {
            for (int i = 0; i <10; i++) {
                Personne personne = Personne.builder().nom("nom" + i).email("nom" + i + "@gmail.com").fonction("fonction" + i).build();
                personneRepository.save(personne);
            }

            reservationRepository.saveAll(List.of(
                    Reservation.builder().nom("reserv-1").contexte("info").date(new Date()).duree(3600L).idPersonne(3L).resourceId(2L).build(),
                    Reservation.builder().nom("reserv-2").contexte("enregistrement").date(new Date()).duree(1800L).idPersonne(5L).resourceId(3L).build()
            ));
        };
    }
}
