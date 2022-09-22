package co.com.history.api.organization;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Configuration
public class OrganizationRouterRest {
@Bean
public RouterFunction<ServerResponse> OrganizationRouterFunction(OrganizationHandler handler) {
    return route(GET("/api/organization"), request -> handler.getAllOrganization())
            .and(route(GET("/api/organization/{id}"), handler::getOrganization));
    //.andRoute(POST("/api/usecase/otherpath"), handler::listenPOSTUseCase).and(route(GET("/api/otherusercase/path"), handler::listenGETOtherUseCase));

    }
}
