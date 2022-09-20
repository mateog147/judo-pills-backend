package co.com.history.usecase.organization.getallorganizations;

import co.com.history.model.organization.Organization;
import co.com.history.model.organization.gateways.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class GetAllOrganizationsUseCase {
    private final OrganizationRepository repository;

    public Flux<Organization> getAll() {
        return repository.findAll();
    }
}
