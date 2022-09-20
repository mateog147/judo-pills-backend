package co.com.history.model.organization.gateways;

import co.com.history.model.organization.Organization;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrganizationRepository {
    Flux<Organization> findAll();

    Mono<Organization> findById(String id);
}
