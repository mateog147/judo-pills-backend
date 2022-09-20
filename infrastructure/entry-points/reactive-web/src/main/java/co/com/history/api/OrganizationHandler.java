package co.com.history.api;

import co.com.history.model.organization.Organization;
import co.com.history.usecase.organization.getallorganizations.GetAllOrganizationsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class OrganizationHandler {
private  final GetAllOrganizationsUseCase getAllOrganizationsUseCase;
//private  final UseCase2 useCase2;
    public Mono<ServerResponse> getAllOrganization() {
        Flux<Organization> organizationFlux = getAllOrganizationsUseCase.getAll();
        return ServerResponse.ok().body(organizationFlux, Flux.class);
    }

    /*public Mono<ServerResponse> listenGETOtherUseCase(ServerRequest serverRequest) {
        // useCase2.logic();
        return ServerResponse.ok().bodyValue("");
    }

    public Mono<ServerResponse> listenPOSTUseCase(ServerRequest serverRequest) {
        // usecase.logic();
        return ServerResponse.ok().bodyValue("");
    }*/
}
