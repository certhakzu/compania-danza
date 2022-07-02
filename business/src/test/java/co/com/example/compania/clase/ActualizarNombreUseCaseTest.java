package co.com.example.compania.clase;

import co.com.example.compania.bailarin.Bailarin;
import co.com.example.compania.bailarin.values.BailarinId;
import co.com.example.compania.bailarin.values.Email;
import co.com.example.compania.bailarin.values.Telefono;
import co.com.example.compania.clase.commands.ActualizarNombreCommand;
import co.com.example.compania.clase.events.ClaseCreada;
import co.com.example.compania.clase.events.NombreActualizado;
import co.com.example.compania.clase.values.*;
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

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ActualizarNombreUseCaseTest {

    @InjectMocks //Para probar
    ActualizarNombreUseCase useCase;

    @Mock //Para asociar a un repositorio
    DomainEventRepository repository;

    @Test
    public void actualizarNombre(){
        // arrange
        ClaseId claseId = ClaseId.of("pppppp");
        Nombre nombre = new Nombre("dddd");
        var command = new ActualizarNombreCommand(claseId, nombre);

        //cuando voy a consultar por ese ID (los eventos de este agregado en especifico)
        when(repository.getEventsBy("pppppp")).thenReturn(history());
        useCase.addRepository(repository);

        // act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (NombreActualizado)events.get(0);
        Assertions.assertEquals("dddd", event.getNombre());

    }

    private List<DomainEvent> history() {
        return List.of(new ClaseCreada(
                new TipoDeClaseId(),
                new FechaProgramadaId(),
                new HoraDeInicio(LocalDateTime.now()),
                new HoraDeFinal(LocalDateTime.now()),
                new Nombre("dddd"),
                new Bailarin(
                        new BailarinId(),
                        new co.com.example.compania.bailarin.values.Nombre("ppp"),
                        new Telefono("33333"),
                        new Email("piter@gmail.com")))
        );
    }
}