package co.com.example.compania.ensayo.events;

import co.com.example.compania.ensayo.values.FechaDeRealizacion;
import co.com.sofka.domain.generic.DomainEvent;

public class FechaDeRealizacionAsignada extends DomainEvent {

    private final FechaDeRealizacion fechaDeRealizacion;

    public FechaDeRealizacionAsignada(FechaDeRealizacion fechaDeRealizacion){
        super("co.com.sofka.compania.ensayo.fechaderealizacionasignada");
        this.fechaDeRealizacion = fechaDeRealizacion;
    }

    public FechaDeRealizacion getFechaDeRealizacion() {
        return fechaDeRealizacion;
    }
}
