package co.com.example.compania.bailarin;


import co.com.example.compania.bailarin.commands.CambiarEmailCommand;
import co.com.example.compania.bailarin.events.BailarinCreado;
import co.com.example.compania.bailarin.events.EmailCambiado;
import co.com.example.compania.bailarin.values.BailarinId;
import co.com.example.compania.bailarin.values.Email;
import co.com.example.compania.bailarin.values.Nombre;
import co.com.example.compania.bailarin.values.Telefono;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CambiarEmailUseCaseTest {

    @InjectMocks //Para probar
    CambiarEmailUseCase useCase;

    @Mock //Para asociar a un repositorio
    DomainEventRepository repository;

    @Test
    void cambiarEmail() {
        // arrange
        BailarinId bailarinId = BailarinId.of("pppppp");
        Email email = new Email("qqqqqqqqqq@ddddddd.ccc");
        var command = new CambiarEmailCommand(bailarinId, email);

        //cuando voy a consultar por ese ID (los eventos de este agregado en especifico)
        when(repository.getEventsBy("pppppp")).thenReturn(history());
        useCase.addRepository(repository);


        // act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (EmailCambiado) events.get(0);
        Assertions.assertEquals("qqqqqqqqqq@ddddddd.ccc", event.getEmail().value());
    }

    private List<DomainEvent> history() {

        BailarinId bailarinId = new BailarinId("xxx");
        Nombre nombreBailarin = new Nombre("Peter");
        Telefono telefonoBailarin = new Telefono("555555");
        Email emailBailarin = new Email("bailarin@gmail.com");

        var event = new BailarinCreado(
                bailarinId,
                nombreBailarin,
                telefonoBailarin,
                emailBailarin
        );

        event.setAggregateRootId("tttt");
        return List.of(event);
    }
}