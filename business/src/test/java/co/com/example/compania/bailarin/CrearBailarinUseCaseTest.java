package co.com.example.compania.bailarin;

import co.com.example.compania.bailarin.commands.CrearBailarinCommand;
import co.com.example.compania.bailarin.events.BailarinCreado;
import co.com.example.compania.bailarin.values.BailarinId;
import co.com.example.compania.bailarin.values.Email;
import co.com.example.compania.bailarin.values.Nombre;
import co.com.example.compania.bailarin.values.Telefono;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearBailarinUseCaseTest {

    private CrearBailarinUseCase useCase;

    @BeforeEach
    private void setup(){
        useCase = new CrearBailarinUseCase();
    }

    @Test
    void crearBailarin(){

        // ARRANGE
        var command = new CrearBailarinCommand(
                BailarinId.of("qqq"),
                new Nombre("alejandro"),
                new Telefono("9999999"),
                new Email("email@gmail.com")
        );

        // ACT
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxx-xxx-xxx")
                .syncExecutor(
                        useCase,
                        new RequestCommand<>(command)
                ).orElseThrow();

        var event = (BailarinCreado)events.getDomainEvents().get(0);

        // ASSERT
        Assertions.assertEquals("alejandro", event.getNombre().value());
        Assertions.assertEquals("9999999", event.getTelefono().value());
        Assertions.assertEquals("email@gmail.com", event.getEmail().value());
    }
}