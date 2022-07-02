package co.com.example.compania.bailarin.commands;

import co.com.example.compania.bailarin.values.ClaseRealizadaId;
import co.com.example.compania.clase.values.ClaseId;
import co.com.example.compania.clase.values.FechaDeRealizacion;
import co.com.sofka.domain.generic.Command;

public class AgregarClaseRealizada extends Command {

    private final ClaseRealizadaId entityId;
    private final ClaseId claseId;
    private final FechaDeRealizacion fechaDeRealizacion;

    public AgregarClaseRealizada(ClaseRealizadaId entityId, ClaseId claseId, FechaDeRealizacion fechaDeRealizacion) {
        this.entityId = entityId;
        this.claseId = claseId;
        this.fechaDeRealizacion = fechaDeRealizacion;
    }

    public ClaseRealizadaId getEntityId() {
        return entityId;
    }

    public ClaseId getClaseId() {
        return claseId;
    }

    public FechaDeRealizacion getFechaDeRealizacion() {
        return fechaDeRealizacion;
    }
}
