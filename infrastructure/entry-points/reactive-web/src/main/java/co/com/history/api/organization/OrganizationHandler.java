package co.com.history.api.organization;

import co.com.history.model.organization.Organization;
import co.com.history.usecase.judoka.getjudokabyid.GetJudokaByIdUseCase;
import co.com.history.usecase.organization.getallorganizations.GetAllOrganizationsUseCase;
import co.com.history.usecase.organization.getorganizationbyid.GetOrganizationByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class OrganizationHandler {
    private final GetAllOrganizationsUseCase getAllOrganizationsUseCase;
    private  final GetOrganizationByIdUseCase getOrganizationByIdUseCase;
    public Mono<ServerResponse> getAllOrganization() {
        Flux<Organization> organizationFlux = getAllOrganizationsUseCase.getAll();
        return ServerResponse.ok().body(organizationFlux, Flux.class);
    }

    public Mono<ServerResponse> getOrganization(ServerRequest serverRequest) {
        String id = serverRequest.pathVariable("id");

        return getOrganizationByIdUseCase.getById(id)
                .flatMap(organization -> ServerResponse.ok().body(getOrganizationByIdUseCase.getById(id), Organization.class))
                .onErrorResume(err -> ServerResponse.badRequest().bodyValue("Id not found"));
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
