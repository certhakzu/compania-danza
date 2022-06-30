package co.com.sofka.compania.bailarin.events;

import co.com.sofka.compania.bailarin.values.ExperienciaId;
import co.com.sofka.domain.generic.DomainEvent;

public class ExperienciaEliminada extends DomainEvent {

    private ExperienciaId experienciaId;
    public ExperienciaEliminada(ExperienciaId experienciaId) {
        super("co.com.sofka.compania.bailarin.experienciaeliminada");
        this.experienciaId = experienciaId;
    }

    public ExperienciaId getExperienciaId() {
        return experienciaId;
    }
}
