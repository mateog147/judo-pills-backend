package co.com.history.usecase.organization.getorganizationbyid;

import co.com.history.model.organization.Organization;
import co.com.history.model.organization.gateways.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class GetOrganizationByIdUseCase {
    private final OrganizationRepository repository;

    public Mono<Organization> getById(String id){
        return repository.findById(id);
    }
}
