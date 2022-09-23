package co.com.history.mockrepository;

import co.com.history.model.organization.Organization;
import co.com.history.model.organization.gateways.OrganizationRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Repository
public class OrganizationMockRepository implements OrganizationRepository {
    private final List<Organization> list = Arrays.asList(
            Organization.builder()
                    .id("o1")
                    .name("International Judo Federation IJF")
                    .image("https://78884ca60822a34fb0e6-082b8fd5551e97bc65e327988b444396.ssl.cf3.rackcdn.com/icons/ijf_logo_300.png")
                    .history("Historia que año se fundo y todo eso")
                    .references(List.of("https://es.wikipedia.org/wiki/Federaci%C3%B3n_Internacional_de_Judo"))
                    .judokasIds(new HashSet<>(List.of("j1")))
                    .year(1951)
                    .build(),
            Organization.builder()
                    .id("o2")
                    .name("Confederación panamericana de judo CPJ")
                    .image("https://panamjudo.org/Content/images/logo-CPJ.white.png")
                    .history("Historia que año se fundo y todo eso")
                    .year(2009)
                    .references(List.of("https://panamjudo.org/es/c/acerca-de-la-cpj-4"))
                    .build()
    );

    @Override
    public Flux<Organization> findAll() {
        return Flux.fromIterable(list);
    }

    @Override
    public Mono<Organization> findById(String id) {
        Optional<Organization> orgFound = list.stream()
                .filter(org -> org.getId().equals(id))
                .findFirst();
        if (orgFound.isPresent()) {
            return Mono.just(orgFound.get());
        }
        return Mono.error(new IllegalArgumentException("Id not found"));
    }
}
