package co.com.example.compania.bailarin;


import co.com.example.compania.bailarin.commands.CambiarTelefonoCommand;
import co.com.example.compania.bailarin.events.BailarinCreado;
import co.com.example.compania.bailarin.events.EmailCambiado;
import co.com.example.compania.bailarin.events.TelefonoCambiado;
import co.com.example.compania.bailarin.values.BailarinId;
import co.com.example.compania.bailarin.values.Email;
import co.com.example.compania.bailarin.values.Nombre;
import co.com.example.compania.bailarin.values.Telefono;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CambiarTelefonoUseCaseTest {

    @InjectMocks
    CambiarTelefonoUseCase useCase;

    @Mock
    DomainEventRepository repository;

    @Test
    void cambiarTelefono(){
        // ARRANGE (creo lo que necesita Test para cambiar el Telefono)
        BailarinId bailarinId = BailarinId.of("11111");
        Telefono telefono = new Telefono("11111111");
        var command = new CambiarTelefonoCommand(bailarinId, telefono);

        // cuando se debe hacer? R: para este agregado en especifico
        when(repository.getEventsBy("11111")).thenReturn(history());

        // ACT
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        // ASSERT ( Ey OJO, Confirmalo!)
        var event = (TelefonoCambiado) events.get(0);
    }

    private List<DomainEvent> history() {
        // Simulo un repositorio para el caso que estoy evaluando, por lo que creo los datos y el o los eventos
        // necesarios para que este caso de uso pueda darse
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

        return  List.of(event);
    }
}
