package co.com.history.mockrepository;

import co.com.history.model.organization.Organization;
import co.com.history.model.organization.gateways.OrganizationRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

@Repository
public class OrganizationMockRepository implements OrganizationRepository {
    private final List<Organization> list = Arrays.asList(
            Organization.builder().id("o1").name("ijf").build(),
            Organization.builder().id("o2").name("cpj").build(),
            Organization.builder().id("o1").name("fcj").build()

    );

    @Override
    public Flux<Organization> findAll() {
        return Flux.fromIterable(list);
    }
}
