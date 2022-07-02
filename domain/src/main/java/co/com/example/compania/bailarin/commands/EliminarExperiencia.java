package co.com.example.compania.bailarin.commands;

import co.com.example.compania.bailarin.values.ExperienciaId;
import co.com.sofka.domain.generic.Command;

public class EliminarExperiencia extends Command {

    private final ExperienciaId experienciaId;

    public EliminarExperiencia(ExperienciaId experienciaId) {
        this.experienciaId = experienciaId;
    }

    public ExperienciaId getExperienciaId() {
        return experienciaId;
    }
}
