package co.com.history.usecase.organization.getorganizationbyid;

import co.com.history.model.judoka.Judoka;
import co.com.history.model.organization.Organization;
import co.com.history.model.organization.gateways.OrganizationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetOrganizationByIdUseCaseTest {

    @Mock
    OrganizationRepository repository;

    @InjectMocks
    GetOrganizationByIdUseCase useCase;

    @Test
    public void get_all_organization_succes(){
        //arrange
        Organization organization = Organization.builder().id("o1").name("IJF").build();
        when(repository.findById("o1")).thenReturn(Mono.just(organization));
        //act and assert
        StepVerifier.create(useCase.getById("o1"))
                .expectNextMatches(organization1 -> organization1.getId().equals("o1"))
                .expectComplete()
                .verify();
    }

}