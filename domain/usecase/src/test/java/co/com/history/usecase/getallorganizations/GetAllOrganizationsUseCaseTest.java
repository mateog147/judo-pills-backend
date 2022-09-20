package co.com.history.usecase.getallorganizations;

import co.com.history.model.organization.Organization;
import co.com.history.model.organization.gateways.OrganizationRepository;
import co.com.history.usecase.organization.getallorganizations.GetAllOrganizationsUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetAllOrganizationsUseCaseTest {
    @Mock
    OrganizationRepository repository;

    @InjectMocks
    GetAllOrganizationsUseCase useCase;

    @Test
    public void get_all_organization_success(){
        Organization org1 = Organization.builder().id("o1").build();
        Organization org2 = Organization.builder().id("o2").build();
        List<Organization> organizations = Arrays.asList(org1, org2);
        when(repository.findAll()).thenReturn(Flux.fromIterable(organizations));

        StepVerifier.create(useCase.getAll())
                .expectNextMatches(organization -> organization.getId().equals("o1"))
                .expectNext(org2)
                .verifyComplete();
    }

}