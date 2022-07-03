package co.com.example.compania.bailarin.commands;

import co.com.example.compania.bailarin.values.ClaseRealizadaId;
import co.com.sofka.domain.generic.Command;

public class EliminarClaseRealizadaCommand extends Command {

    private final ClaseRealizadaId entityId;

    public EliminarClaseRealizadaCommand(ClaseRealizadaId entityId) {
        this.entityId = entityId;
    }

    public ClaseRealizadaId getEntityId() {
        return entityId;
    }
}
