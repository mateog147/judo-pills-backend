package co.com.history.mockrepository;

import co.com.history.model.organization.Organization;
import co.com.history.model.organization.gateways.OrganizationRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public class OrganizationMockRepository implements OrganizationRepository {
    @Override
    public Flux<Organization> findAll() {
        return null;
    }
}
