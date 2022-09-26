package co.com.history.api.organization;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class OrganizationRouterRest {
    @Bean
    public RouterFunction<ServerResponse> OrganizationRouterFunction(OrganizationHandler handler) {
        return route(GET("/api/organizations"), request -> handler.getAllOrganization())
                .and(route(GET("/api/organizations/{id}"), handler::getOrganization))
                .andRoute(POST("/api/organizations"), handler::addOrganization);

    }
}
