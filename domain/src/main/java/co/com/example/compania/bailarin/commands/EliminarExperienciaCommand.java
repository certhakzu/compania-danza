package co.com.example.compania.bailarin.commands;

import co.com.example.compania.bailarin.values.ExperienciaId;
import co.com.sofka.domain.generic.Command;

public class EliminarExperienciaCommand extends Command {

    private final ExperienciaId experienciaId;

    public EliminarExperienciaCommand(ExperienciaId experienciaId) {
        this.experienciaId = experienciaId;
    }

    public ExperienciaId getExperienciaId() {
        return experienciaId;
    }
}
