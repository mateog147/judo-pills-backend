package co.com.history.mockrepository;

import co.com.history.model.judoka.Judoka;
import co.com.history.model.judoka.gateways.JudokaRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class JudokaMockRepository implements JudokaRepository {

    private final List<Judoka> list = Arrays.asList(
            Judoka.builder()
                    .id("j1")
                    .name("Jigoro Kano")
                    .image("https://es.wikipedia.org/wiki/Jigor%C5%8D_Kan%C5%8D#/media/Archivo:Kan%C5%8D_Jigor%C5%8D_c1937.jpg")
                    .history("")
                    .build(),
            Judoka.builder().id("j2").name("Keiko Fukuda").build(),
            Judoka.builder().id("j3").name("Shohei Ono").build()
    );
    @Override
    public Flux<Judoka> findAll() {
        return Flux.fromIterable(list);
    }

    @Override
    public Mono<Judoka> findById(String id) {

        Optional<Judoka> judokaFound = list.stream()
                .filter(judoka -> judoka.getId().equals(id))
                .findFirst();
        if(judokaFound.isPresent()){
            return Mono.just(judokaFound.get());
        }
        return Mono.error(new IllegalArgumentException("Id not found"));

    }
}
