package co.com.history.api.judoka;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
@AllArgsConstructor
public class JudokaRouterRest {
    private final JudokaHandler handler;
@Bean
public RouterFunction<ServerResponse> judokaRouterFunction() {
    return route(GET("/api/judoka"), request -> handler.getAllJudokas());

    }
}
