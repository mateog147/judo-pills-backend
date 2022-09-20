package co.com.history.usecase.judoka.getjudokabyid;

import co.com.history.model.judoka.Judoka;
import co.com.history.model.judoka.gateways.JudokaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetJudokaByIdUseCaseTest {

    @Mock
    JudokaRepository repository;

    @InjectMocks
    GetJudokaByIdUseCase useCase;

    @Test
    public void get_judoka_by_id(){
        //arrange
        Judoka judoka = Judoka.builder().id("j1").name("Jigoro Kano").build();
        when(repository.findById("j1")).thenReturn(Mono.just(judoka));
        //act and assert
        StepVerifier.create(useCase.getById("j1"))
                .expectNextMatches(judoka1 -> judoka1.getId().equals("j1"))
                .expectComplete()
                .verify();
    }

}