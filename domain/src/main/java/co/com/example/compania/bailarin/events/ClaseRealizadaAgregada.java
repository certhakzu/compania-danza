package co.com.example.compania.bailarin.events;

import co.com.example.compania.bailarin.values.ClaseRealizadaId;
import co.com.example.compania.clase.values.ClaseId;
import co.com.example.compania.clase.values.FechaDeRealizacion;
import co.com.sofka.domain.generic.DomainEvent;

public class ClaseRealizadaAgregada extends DomainEvent {

    private ClaseRealizadaId claseRealizadaId;
    private ClaseId claseId;
    private FechaDeRealizacion fechaDeRealizacion;

    public ClaseRealizadaAgregada(ClaseRealizadaId claseRealizadaId, ClaseId claseId, FechaDeRealizacion fechaDeRealizacion) {
        super("co.com.sofka.compania.bailarin.claserealizadaagregada");
        this.claseRealizadaId = claseRealizadaId;
        this.claseId = claseId;
        this.fechaDeRealizacion = fechaDeRealizacion;
    }

    public ClaseRealizadaId getClaseRealizadaId() {
        return claseRealizadaId;
    }

    public ClaseId getClaseId() {
        return claseId;
    }

    public FechaDeRealizacion getFechaDeRealizacion() {
        return fechaDeRealizacion;
    }
}
