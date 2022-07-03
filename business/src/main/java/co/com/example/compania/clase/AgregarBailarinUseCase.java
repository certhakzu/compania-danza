package co.com.example.compania.clase;

import co.com.example.compania.bailarin.Bailarin;
import co.com.example.compania.bailarin.values.BailarinId;
import co.com.example.compania.clase.events.BailarinAgregado;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;

public class AgregarBailarinUseCase extends UseCase<TriggeredEvent<BailarinAgregado>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<BailarinAgregado> bailarinAgregadoTriggeredEvent) {
        var event = bailarinAgregadoTriggeredEvent.getDomainEvent();

        var bailarin = Bailarin.from(
                BailarinId.of("qqq"),
                repository().getEventsBy(event.getBailarinId().value())
        );
        var clase = Clase.from(event.getClaseId(), repository().getEventsBy(event.getClaseId().value()));

        clase.agregarBailarin(
                event.getClaseId(),
                event.getBailarinId(),
                event.getNombre(),
                event.getTelefono(),
                event.getEmail()
        );

        emit().onResponse(new ResponseEvents(clase.getUncommittedChanges()));
        emit().onResponse(new ResponseEvents(bailarin.getUncommittedChanges()));
    }
}
