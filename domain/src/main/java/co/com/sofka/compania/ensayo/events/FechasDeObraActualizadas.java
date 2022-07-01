package co.com.sofka.compania.ensayo.events;

import co.com.sofka.compania.ensayo.values.FechaDeRealizacion;
import co.com.sofka.compania.ensayo.values.FechaProgramadaId;
import co.com.sofka.domain.generic.DomainEvent;

public class FechasDeObraActualizadas extends DomainEvent {

    private FechaDeRealizacion fechaDeRealizacion;
    private FechaProgramadaId fechaProgramadaId;

    public FechasDeObraActualizadas(FechaDeRealizacion fechaDeRealizacion, FechaProgramadaId fechaProgramadaId){
        super("co.com.sofka.compania.ensayo.fechasdeobraactualizadas");
        this.fechaDeRealizacion = fechaDeRealizacion;
        this.fechaProgramadaId = fechaProgramadaId;
    }
}
