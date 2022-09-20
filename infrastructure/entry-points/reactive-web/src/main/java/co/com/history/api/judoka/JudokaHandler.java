package co.com.history.api.judoka;

import co.com.history.model.judoka.Judoka;
import co.com.history.usecase.judoka.getalljudokas.GetAllJudokasUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class JudokaHandler {
    private  final GetAllJudokasUseCase getAllJudokasUseCase;
//private  final UseCase2 useCase2;
    public Mono<ServerResponse> getAllJudokas() {

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(getAllJudokasUseCase.getJudokas(), Judoka.class)
                .onErrorResume(e->ServerResponse.badRequest().bodyValue(""));
    }

    public Mono<ServerResponse> listenPOSTUseCase(ServerRequest serverRequest) {
        // usecase.logic();
        return ServerResponse.ok().bodyValue("");
    }
}
