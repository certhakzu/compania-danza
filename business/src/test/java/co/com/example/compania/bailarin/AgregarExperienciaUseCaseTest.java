package co.com.example.compania.bailarin;

import co.com.example.compania.bailarin.commands.AgregarExperienciaCommand;
import co.com.example.compania.bailarin.events.BailarinCreado;
import co.com.example.compania.bailarin.events.ExperienciaAgregada;
import co.com.example.compania.bailarin.values.*;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AgregarExperienciaUseCaseTest {

    private AgregarExperienciaUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    private void setup(){
        useCase = new AgregarExperienciaUseCase();
        repository = mock(DomainEventRepository.class);
        useCase.addRepository(repository);
    }

    @Test
    void agregarExperiencia(){
        var command = new AgregarExperienciaCommand(
                BailarinId.of("xxx"),
                ExperienciaId.of("ccc"),
                new Estilo("folclor"),
                new Lugar("ekobios"),
                new Duracion(2.0F)
        );

        when(repository.getEventsBy(any())).thenReturn(history());


        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("fff")
                .syncExecutor(
                        useCase,
                        new RequestCommand<>(command)
                ).orElseThrow();
        var event = (ExperienciaAgregada) events.getDomainEvents().get(0);


        Assertions.assertEquals("ccc", event.getExperienciaId().value());
        Assertions.assertEquals("folclor", event.getEstilo().value());
        Assertions.assertEquals("ekobios", event.getLugar().value());
        Assertions.assertEquals(2.0F, event.getDuracion().value());

    }

    private List<DomainEvent> history() {

        return List.of(new BailarinCreado(
                BailarinId.of("vvv"),
                new Nombre("patrocia"),
                new Telefono("7777777"),
                new Email("valor@gmail.com")
        ));
    }


}