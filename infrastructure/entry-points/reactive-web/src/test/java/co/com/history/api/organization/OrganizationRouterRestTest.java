package co.com.history.api.organization;

import co.com.history.model.judoka.Judoka;
import co.com.history.model.organization.Organization;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {OrganizationRouterRest.class, OrganizationRouterRest.class})
@WebFluxTest
class OrganizationRouterRestTest {

    @MockBean
    OrganizationHandler handler;

    @Autowired
    @InjectMocks
    OrganizationRouterRest routerRest;


    @Test
    public void get_organizations_success() {
        WebTestClient testClient = WebTestClient
                .bindToRouterFunction(routerRest.OrganizationRouterFunction(handler))
                .build();

        Organization org1 = Organization.builder().id("1").build();
        Organization org2 = Organization.builder().id("2").build();
        Organization org3 = Organization.builder().id("3").build();
        List<Organization> organizations = Arrays.asList(org1, org2, org3);
        Mono<ServerResponse> response = ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(Flux.fromIterable(organizations), Judoka.class);


        when(handler.getAllOrganization()).thenReturn(response);

        testClient.get().uri("/api/organization")
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBodyList(Organization.class)
                .isEqualTo(organizations);
    }

    @Test
    public void get_organization_by_id_success() {
        WebTestClient testClient = WebTestClient
                .bindToRouterFunction(routerRest.OrganizationRouterFunction(handler))
                .build();
        String id = "xxx";
        Organization org = Organization.builder().id(id).build();
        Mono<ServerResponse> response = ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(org), Organization.class);
        when(handler.getOrganization(any())).thenReturn(response);

        testClient.get().uri("/api/organization/" + id)
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBody(Organization.class)
                .isEqualTo(org);
        verify(handler).getOrganization(any());


    }
}