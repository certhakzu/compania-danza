package co.com.example.compania.bailarin;


import co.com.example.compania.bailarin.commands.AgregarClaseRealizadaCommand;
import co.com.example.compania.bailarin.events.BailarinCreado;
import co.com.example.compania.bailarin.events.ClaseRealizadaAgregada;
import co.com.example.compania.bailarin.values.*;
import co.com.example.compania.clase.values.ClaseId;
import co.com.example.compania.clase.values.FechaDeRealizacion;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AgregarClaseRealizadaUseCaseTest {

    private AgregarClaseRealizadaUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    private void setup(){
        useCase = new AgregarClaseRealizadaUseCase();
        repository = mock(DomainEventRepository.class);
        useCase.addRepository(repository);
    }

    @Test
    void agregarClaseRealizada(){
        var command = new AgregarClaseRealizadaCommand(
                BailarinId.of("xxx"),
                ClaseRealizadaId.of("mmm"),
                ClaseId.of("ppp"),
                new FechaDeRealizacion(LocalDate.MIN)
        );

        when(repository.getEventsBy(any())).thenReturn(history());


        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("fff")
                .syncExecutor(
                        useCase,
                        new RequestCommand<>(command)
                ).orElseThrow();

        var event = (ClaseRealizadaAgregada) events.getDomainEvents().get(0);

        Assertions.assertEquals("mmm", event.getClaseRealizadaId().value());
        Assertions.assertEquals("ppp", event.getClaseId().value());
        Assertions.assertEquals(event.getFechaDeRealizacion(), event.getFechaDeRealizacion());
    }

    private List<DomainEvent> history() {

        return List.of(new BailarinCreado(
                new Nombre("patrocia"),
                new Telefono("7777777"),
                new Email("valor@gmail.com")
        ));
    }

}