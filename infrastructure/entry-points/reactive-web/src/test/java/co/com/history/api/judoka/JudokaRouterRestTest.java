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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
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
        Mono<ServerResponse> response = ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(Flux.fromIterable(judokas), Judoka.class);

        when(handler.getAllJudokas()).thenReturn(response);

        testClient.get().uri("/api/judokas")
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBodyList(Judoka.class)
                .isEqualTo(judokas);
    }

    @Test
    public void get_judoka_by_id_success() {
        WebTestClient testClient = WebTestClient
                .bindToRouterFunction(routerRest.judokaRouterFunction())
                .build();

        String id = "1";
        Judoka judoka1 = Judoka.builder().id(id).build();
        Mono<ServerResponse> response = ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(judoka1), Judoka.class);

        when(handler.getJudoka(any())).thenReturn(response);

        testClient.get().uri("/api/judokas/" + id)
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBody(Judoka.class)
                .isEqualTo(judoka1);
        verify(handler).getJudoka(any());
    }

}