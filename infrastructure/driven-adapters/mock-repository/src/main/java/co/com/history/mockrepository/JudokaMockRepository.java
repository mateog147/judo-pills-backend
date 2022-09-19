package co.com.history.mockrepository;

import co.com.history.model.judoka.Judoka;
import co.com.history.model.judoka.gateways.JudokaRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

@Repository
public class JudokaMockRepository implements JudokaRepository {

    private final List<Judoka> list = Arrays.asList(
            Judoka.builder().id("j1").name("Jigoro Kano").build(),
            Judoka.builder().id("j2").name("Keiko Fukuda").build(),
            Judoka.builder().id("j3").name("Shohei Ono").build()
    );
    @Override
    public Flux<Judoka> findAll() {
        return Flux.fromIterable(list);
    }
}
