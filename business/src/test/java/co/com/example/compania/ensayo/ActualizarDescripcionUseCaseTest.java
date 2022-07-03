package co.com.example.compania.ensayo;

import co.com.example.compania.ensayo.commands.ActualizarDescripcionCommand;
import co.com.example.compania.ensayo.events.DescripcionActualizada;
import co.com.example.compania.ensayo.events.EnsayoCreado;
import co.com.example.compania.ensayo.values.*;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.when;

class ActualizarDescripcionUseCaseTest {

    @InjectMocks
    private ActualizarDescripcionUseCase useCase;

    @Mock
    DomainEventRepository repository;

    @Test
    void actualizarDescripcion(){
        // ARRANGE
        EnsayoId ensayoId = EnsayoId.of("qqqq");
        Descripcion descripcion = new Descripcion("wwwwwwwwwwww");
        var command = new ActualizarDescripcionCommand(ensayoId, descripcion);

        //cuando voy a consultar por ese ID (los eventos de este agregado en especifico)
        when(repository.getEventsBy("qqqq")).thenReturn(history());
        useCase.addRepository(repository);

        // ACT
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (DescripcionActualizada) events.get(0);

        // ASSERT
        Assertions.assertEquals("wwwwwwwwww", event.getDescripcion().value()    );

    }

    private List<DomainEvent> history() {
        FechaProgramadaId fechaProgramadaId = new FechaProgramadaId("qqq");
        ObraId obraId = new ObraId("www");
        HoraDeInicio horaDeInicio = new HoraDeInicio(LocalDateTime.MIN);
        HoraDeFinal horaDeFinal= new HoraDeFinal(LocalDateTime.MAX);
        Descripcion descripcion = new Descripcion("rrrrrrrrrrrr");

        EnsayoId ensayoId;
        var event1 = new EnsayoCreado(fechaProgramadaId, obraId, horaDeInicio, horaDeFinal, descripcion);
        var event2 = new DescripcionActualizada(descripcion);

        event1.setAggregateRootId("tttt");
        event2.setAggregateRootId("tttt");
        return List.of(event1, event2);
    }

}