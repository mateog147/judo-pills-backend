package co.com.history.usecase.getalljudokas;

import co.com.history.model.judoka.Judoka;
import co.com.history.model.judoka.gateways.JudokaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class GetAllJudokasUseCase {
    private final JudokaRepository repository;
    public Flux<Judoka> getJudokas() {
        return repository.findAll();
    }
}
