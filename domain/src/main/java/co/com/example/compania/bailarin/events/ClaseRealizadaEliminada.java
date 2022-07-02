package co.com.example.compania.bailarin.events;

import co.com.example.compania.bailarin.values.ClaseRealizadaId;
import co.com.sofka.domain.generic.DomainEvent;

public class ClaseRealizadaEliminada extends DomainEvent {

    private ClaseRealizadaId claseRealizadaId;

    public ClaseRealizadaEliminada(ClaseRealizadaId claseRealizadaId) {
        super("co.com.sofka.compania.bailarin.claserealizadaeliminada");
        this.claseRealizadaId = claseRealizadaId;
    }

    public ClaseRealizadaId getClaseRealizadaId() {
        return claseRealizadaId;
    }
}
