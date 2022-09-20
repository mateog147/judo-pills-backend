package co.com.history.usecase.judoka.getjudokabyid;

import co.com.history.model.judoka.Judoka;
import co.com.history.model.judoka.gateways.JudokaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class GetJudokaByIdUseCase {
    private final JudokaRepository repository;

    public Mono<Judoka> getById(String id){
        return repository.findById(id);
    }
}
