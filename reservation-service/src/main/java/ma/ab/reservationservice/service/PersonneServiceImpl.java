package ma.ab.reservationservice.service;

import ma.ab.reservationservice.dtos.PersonneResponseDto;
import ma.ab.reservationservice.entities.Personne;
import ma.ab.reservationservice.mappers.PersonneMapper;
import ma.ab.reservationservice.repositories.PersonneRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonneServiceImpl implements PersonneService{
    private PersonneMapper personneMapper;
    private PersonneRepository personneRepository;

    public PersonneServiceImpl(PersonneMapper personneMapper, PersonneRepository personneRepository) {
        this.personneMapper = personneMapper;
        this.personneRepository = personneRepository;
    }

    @Override
    public List<PersonneResponseDto> getPersonnes() {
        List<Personne> personnes = personneRepository.findAll();
        return personnes.stream().map(personneMapper::from).collect(Collectors.toList());
    }

    @Override
    public PersonneResponseDto getPersonneById(Long id) {
        Personne personne = personneRepository.findById(id).orElse(null);
        if (personne == null) throw new RuntimeException(String.format("personne by Id : %d is not found", id));
        return personneMapper.from(personne);
    }
}
