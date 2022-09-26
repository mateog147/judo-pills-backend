package co.com.history.usecase.organization.addneworganization;

import co.com.history.model.organization.Organization;
import co.com.history.model.organization.gateways.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class AddNewOrganizationUseCase {
    private final OrganizationRepository repository;

    public Mono<Organization> add(Organization organization){
        return repository.save(organization);
    }
}
