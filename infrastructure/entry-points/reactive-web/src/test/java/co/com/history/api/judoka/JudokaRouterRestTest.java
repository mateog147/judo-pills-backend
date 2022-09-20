package co.com.history.api.judoka;

import co.com.history.model.judoka.Judoka;
import org.junit.jupiter.api.Test;
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

import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {JudokaRouterRest.class, JudokaHandler.class})
@WebFluxTest
class JudokaRouterRestTest {
    @Autowired
    private JudokaRouterRest routerRest;

    @MockBean
    JudokaHandler handler;

    @Test
    public void get_judokas_success() {
        WebTestClient testClient = WebTestClient
                .bindToRouterFunction(routerRest.judokaRouterFunction())
                .build();

        Judoka judoka1 = Judoka.builder().id("1").build();
        Judoka judoka2 = Judoka.builder().id("2").build();
        Judoka judoka3 = Judoka.builder().id("3").build();
        List<Judoka> judokas = Arrays.asList(judoka1, judoka2, judoka3);
        Mono<ServerResponse> response =ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(Flux.fromIterable(judokas), Judoka.class);

        when(handler.getAllJudokas()).thenReturn(response);

        testClient.get().uri("/api/judoka")
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBodyList(Judoka.class)
                .isEqualTo(judokas);
    }

}