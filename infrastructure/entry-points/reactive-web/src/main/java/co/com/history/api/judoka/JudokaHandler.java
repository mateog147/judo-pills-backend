package co.com.history.api.judoka;

import co.com.history.model.judoka.Judoka;
import co.com.history.usecase.judoka.getalljudokas.GetAllJudokasUseCase;
import co.com.history.usecase.judoka.getjudokabyid.GetJudokaByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.logging.Logger;

@Component
@RequiredArgsConstructor
public class JudokaHandler {
    private  final GetAllJudokasUseCase getAllJudokasUseCase;
    private  final GetJudokaByIdUseCase getJudokaByIdUseCase;

    private final Logger logger = Logger.getLogger("logger");
    public Mono<ServerResponse> getAllJudokas() {

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(getAllJudokasUseCase.getJudokas(), Judoka.class)
                .onErrorResume(e->ServerResponse.badRequest().bodyValue(""));
    }

    public Mono<ServerResponse> getJudoka(ServerRequest serverRequest) {
        String id = serverRequest.pathVariable("id");
        return getJudokaByIdUseCase.getById(id)
                .flatMap(judoka -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                        .body(Mono.just(judoka), Judoka.class))
                .onErrorResume(e -> {
                    logger.warning(e.getMessage().concat(" id:").concat(id));
                    return ServerResponse.badRequest().bodyValue("Id not found");
                });
    }
}
