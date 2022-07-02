package co.com.sofka.compania.bailarin.commands;

import co.com.sofka.compania.bailarin.values.ClaseRealizadaId;
import co.com.sofka.domain.generic.Command;

public class EliminarClaseRealizada extends Command {

    private final ClaseRealizadaId entityId;

    public EliminarClaseRealizada(ClaseRealizadaId entityId) {
        this.entityId = entityId;
    }

    public ClaseRealizadaId getEntityId() {
        return entityId;
    }
}
