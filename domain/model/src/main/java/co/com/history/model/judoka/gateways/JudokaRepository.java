package co.com.history.model.judoka.gateways;

import co.com.history.model.judoka.Judoka;
import reactor.core.publisher.Flux;

public interface JudokaRepository {
    Flux<Judoka> findAll();
}
