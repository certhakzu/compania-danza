package co.com.example.compania.clase;

import co.com.example.compania.bailarin.events.BailarinCreado;
import co.com.example.compania.bailarin.values.BailarinId;
import co.com.example.compania.bailarin.values.Email;
import co.com.example.compania.bailarin.values.Nombre;
import co.com.example.compania.bailarin.values.Telefono;
import co.com.example.compania.clase.events.BailarinAgregado;
import co.com.example.compania.clase.values.ClaseId;
import co.com.example.compania.ensayo.events.EnsayoCreado;
import co.com.example.compania.ensayo.values.*;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarBailarinUseCaseTest {


    @InjectMocks
    AgregarBailarinUseCase useCase;

    @Mock
    DomainEventRepository repository;

    @Test
    void agregarBailarin(){
        // ARRANGE
        ClaseId claseId = ClaseId.of("qqq");
        BailarinId bailarinId = BailarinId.of("www");
        Nombre nombre = new Nombre("peter");
        Telefono telefono = new Telefono("77777777");
        Email email = new Email("piter@gmail.com");

        var event = new BailarinAgregado(claseId, bailarinId, nombre, telefono, email);

        when(repository.getEventsBy("qqq")).thenReturn(history());
        useCase.addRepository(repository);


        // ACT
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(event.getClaseId().value())
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        // ASSERT
        var bailarinAgregado = (BailarinAgregado)events.get(0);
        Assertions.assertEquals("www", event.getBailarinId().value());
        Assertions.assertEquals("peter", event.getNombre().value());
        Assertions.assertEquals("77777777", event.getTelefono().value());
        Assertions.assertEquals("piter@gmail.com", event.getEmail().value());
    }

    private List<DomainEvent> history() {
        var event1 = new EnsayoCreado(
                FechaProgramadaId.of("zzz"),
                new ObraId("xxx"),
                new HoraDeInicio(LocalDateTime.MIN),
                new HoraDeFinal(LocalDateTime.MAX),
                new Descripcion("ccccccccccccccc")
        );

        var event2 = new BailarinCreado(
                BailarinId.of("bbb"),
                new Nombre("pepe"),
                new Telefono("555555555"),
                new Email("pepe@gmail.com")
        );

        return List.of(event1, event2);
    }
}