package co.com.history.mockrepository;

import co.com.history.model.judoka.Judoka;
import co.com.history.model.judoka.gateways.JudokaRepository;
import co.com.history.model.judoka.values.Achievement;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.*;

@Repository
public class JudokaMockRepository implements JudokaRepository {

    private final Set<Achievement> achievementSet = new HashSet<>(Arrays.asList(
            Achievement.builder()
                    .event("Juegos Olímpicos Tokyo")
                    .place(1)
                    .year(2021)
                    .build(),
            Achievement.builder()
                    .event("Campeonato mundial Tokyo")
                    .place(1)
                    .year(2019)
                    .build()
    ));

    private final List<Judoka> list = Arrays.asList(
            Judoka.builder()
                    .id("j1")
                    .name("Jigoro Kano")
                    .image("https://es.wikipedia.org/wiki/Jigor%C5%8D_Kan%C5%8D#/media/Archivo:Kan%C5%8D_Jigor%C5%8D_c1937.jpg")
                    .history("Historia del judo de Kano")
                    .beginning("Comenzo entrenado ju jutsu en las esvcuelas de Kito y la Tenjin shin yoryu")
                    .rank("Fundador")
                    .references(Arrays.asList("https://es.wikipedia.org/wiki/Jigor%C5%8D_Kan%C5%8D", "http://kodokanjudoinstitute.org/en/doctrine/history/"))
                    .build(),
            Judoka.builder()
                    .id("j2")
                    .name("Keiko Fukuda")
                    .image("https://www.petitsapiens.cat/uploads/s1/85/85/33/fukuda-0_63_420x574.jpeg")
                    .history("Historia del camino de keiko")
                    .beginning("Comenzo entrenando judo con Kano shihan")
                    .rank("10 Dan")
                    .references(List.of("https://es.wikipedia.org/wiki/Keiko_Fukuda"))
                    .build(),
            Judoka.builder()
                    .id("j3")
                    .name("Shohei Ono")
                    .image("https://static3.elcorreo.com/www/multimedia/202107/26/media/cortadas/ShoheiOno-k0UH-U15063689038EwH-624x385@RC.jpg")
                    .history("Historia del camino de Ono")
                    .beginning("Comenzo entrenando judo con no se")
                    .rank("5 Dan")
                    .achievements(achievementSet)
                    .references(List.of("https://www.ijf.org/judoka/4018"))
                    .build()
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
        if (judokaFound.isPresent()) {
            return Mono.just(judokaFound.get());
        }
        return Mono.error(new IllegalArgumentException("Id not found"));

    }
}
