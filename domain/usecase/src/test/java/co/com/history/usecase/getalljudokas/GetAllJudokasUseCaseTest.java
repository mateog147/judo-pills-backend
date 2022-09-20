package co.com.history.usecase.getalljudokas;

import co.com.history.model.judoka.Judoka;
import co.com.history.model.judoka.gateways.JudokaRepository;
import co.com.history.usecase.judoka.getalljudokas.GetAllJudokasUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetAllJudokasUseCaseTest {

    @Mock
    JudokaRepository repository;

    @InjectMocks
    GetAllJudokasUseCase getAllJudokasUseCase;

    @Test
    public void get_all_judokas_succes(){
        //arrange
        Judoka judoka1 = Judoka.builder().id("1").build();
        Judoka judoka2 = Judoka.builder().id("2").build();
        Judoka judoka3 = Judoka.builder().id("3").build();
        List<Judoka> judokas = Arrays.asList(judoka1, judoka2, judoka3);
        when(repository.findAll()).thenReturn(Flux.fromIterable(judokas));
        //act y assert
        StepVerifier.create(getAllJudokasUseCase.getJudokas())
                .expectNextMatches(judoka -> judoka.getId().equals("1"))
                .expectNextMatches(judoka -> judoka.getId().equals("2"))
                .expectNextMatches(judoka -> judoka.getId().equals("3"))
                .expectComplete()
                .verify();
    }

}