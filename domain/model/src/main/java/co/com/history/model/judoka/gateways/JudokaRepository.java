package co.com.history.model.judoka.gateways;

import co.com.history.model.judoka.Judoka;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface JudokaRepository {
    Flux<Judoka> findAll();

    Mono<Judoka> findById(String id);

}
