package co.com.example.compania.clase.events;

import co.com.example.compania.clase.values.FechaDeRealizacion;
import co.com.sofka.domain.generic.DomainEvent;

public class FechaDeRealizacionAsignada extends DomainEvent {

    private final FechaDeRealizacion fechaDeRealizacion;

    public FechaDeRealizacionAsignada(FechaDeRealizacion fechaDeRealizacion) {
        super("co.com.sofka.compania.clase.fechaderealizacionasignada");
        this.fechaDeRealizacion = fechaDeRealizacion;
    }

    public FechaDeRealizacion getFechaDeRealizacion() {
        return fechaDeRealizacion;
    }
}
