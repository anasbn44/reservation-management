package ma.ab.reservationservice.service;

import ma.ab.reservationservice.dtos.PersonneResponseDto;
import ma.ab.reservationservice.dtos.ReservationResponseDto;
import ma.ab.reservationservice.entities.Reservation;
import ma.ab.reservationservice.mappers.PersonneMapper;
import ma.ab.reservationservice.mappers.ReservationMapper;
import ma.ab.reservationservice.model.Resource;
import ma.ab.reservationservice.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService{
    private ReservationMapper reservationMapper;
    private ReservationRepository reservationRepository;
    private PersonneService personneService;
    private PersonneMapper personneMapper;
    @Value("${resource.service.base.uri}")
    private String resourceServiceBaseUri;

    public ReservationServiceImpl(ReservationMapper reservationMapper, ReservationRepository reservationRepository, PersonneService personneService, PersonneMapper personneMapper) {
        this.reservationMapper = reservationMapper;
        this.reservationRepository = reservationRepository;
        this.personneService = personneService;
        this.personneMapper = personneMapper;
    }

    @Override
    public List<Reservation> getReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
//        return reservations.stream().map(reservationMapper::from).collect(Collectors.toList());
        return reservations;
    }

    @Override
    public Reservation getReservationById(Long id) {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) authentication;
//        DefaultOidcUser oidcUser = (DefaultOidcUser) oAuth2AuthenticationToken.getPrincipal();
        String jwtTokenValue = jwtAuthenticationToken.getToken().getTokenValue();
        Reservation reservation = reservationRepository.findById(id).orElse(null);
        if (reservation == null) throw new RuntimeException(String.format("reservation by Id : %d is not found", id));
        PersonneResponseDto personne = personneService.getPersonneById(reservation.getId());
        reservation.setPersonne(personneMapper.to(personne));
        RestClient restClient = RestClient.create(resourceServiceBaseUri);
        Resource resource = restClient.get()
                .uri("/Resources/" + reservation.getResourceId())
                .headers(httpHeaders -> httpHeaders.set(HttpHeaders.AUTHORIZATION, "Bearer " + jwtTokenValue))
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
        reservation.setResource(resource);
        return reservation;
    }
}
