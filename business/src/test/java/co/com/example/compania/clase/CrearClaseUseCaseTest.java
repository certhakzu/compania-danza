package co.com.example.compania.clase;

import co.com.example.compania.bailarin.Bailarin;
import co.com.example.compania.bailarin.values.BailarinId;
import co.com.example.compania.bailarin.values.Email;
import co.com.example.compania.bailarin.values.Telefono;
import co.com.example.compania.clase.commands.CrearClaseCommand;
import co.com.example.compania.clase.events.ClaseCreada;
import co.com.example.compania.clase.values.*;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class CrearClaseUseCaseTest {

    private CrearClaseUseCase useCase;

    @BeforeEach
    private void setup(){
        useCase = new CrearClaseUseCase();
    }

    @Test
    void crearClase(){
        // ARRANGE
        var command = new CrearClaseCommand(
                ClaseId.of("rrr"),
                TipoDeClaseId.of("qqq"),
                FechaProgramadaId.of("www"),
                new HoraDeInicio(LocalDateTime.MIN),
                new HoraDeFinal(LocalDateTime.MAX),
                new Nombre("ballet"),
                new Bailarin(
                        BailarinId.of("mmm"),
                        new co.com.example.compania.bailarin.values.Nombre("peter"),
                        new Telefono("88888888"),
                        new Email("email@gmail.com")
                )
        );

        // ACT
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxx--xxx")
                .syncExecutor(
                        useCase,
                        new RequestCommand<>(command)
                ).orElseThrow();
        var event = (ClaseCreada) events.getDomainEvents().get(0);

        // ASSERT
        Assertions.assertEquals("qqq", event.getTipoDeClaseId().value());
        Assertions.assertEquals("www", event.getFechaProgramadaId().value());
        Assertions.assertEquals(LocalDateTime.MIN, event.getHoraDeInicio().value());
        Assertions.assertEquals(LocalDateTime.MAX, event.getHoraDeFinal().value());
        Assertions.assertEquals("ballet", event.getNombre().value());
        Assertions.assertEquals(new Bailarin(
                BailarinId.of("mmm"),
                new co.com.example.compania.bailarin.values.Nombre("peter"),
                new Telefono("88888888"),
                new Email("email@gmail.com")),
                event.getProfesor()
        );
    }
}