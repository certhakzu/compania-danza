package co.com.example.compania.ensayo;


import co.com.example.compania.ensayo.commands.CrearEnsayoCommand;
import co.com.example.compania.ensayo.events.EnsayoCreado;
import co.com.example.compania.ensayo.values.*;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CrearEnsayoUseCaseTest {

    private CrearEnsayoUseCase useCase;

    @BeforeEach
    private void setup(){
        useCase = new CrearEnsayoUseCase();
    }

    @Test
    void crearEnsayo(){
        // ARRANGE
        var command = new CrearEnsayoCommand(
                EnsayoId.of("qqq"),
                FechaProgramadaId.of("www"),
                ObraId.of("eee"),
                new HoraDeInicio(LocalDateTime.MIN),
                new HoraDeFinal(LocalDateTime.MAX),
                new Descripcion("rrrrrrrrrrrrrrrrrrr")
        );

        // ACT
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxx--xxx")
                .syncExecutor(
                        useCase,
                        new RequestCommand<>(command)
                ).orElseThrow();
        var event = (EnsayoCreado) events.getDomainEvents().get(0);

        //ASSERT
        Assertions.assertEquals("www", event.getFechaProgramadaId().value());
        Assertions.assertEquals("eee", event.getObraId().value());
        Assertions.assertEquals(new HoraDeInicio(LocalDateTime.MIN), event.getHoraDeInicio());
        Assertions.assertEquals(new HoraDeFinal(LocalDateTime.MAX), event.getHoraDeFinal());
        Assertions.assertEquals("rrrrrrrrrrrrrrrrrrr", event.getDescripcion().value());
    }

}