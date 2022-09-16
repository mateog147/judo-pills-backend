package co.com.history.model.organization.gateways;

import co.com.history.model.organization.Organization;
import reactor.core.publisher.Flux;

public interface OrganizationRepository {
    Flux<Organization> findAll();
}
