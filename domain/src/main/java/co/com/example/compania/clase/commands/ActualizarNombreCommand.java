package co.com.example.compania.clase.commands;

import co.com.example.compania.clase.values.ClaseId;
import co.com.example.compania.clase.values.Nombre;
import co.com.sofka.domain.generic.Command;

public class ActualizarNombreCommand extends Command {

    private final ClaseId claseId;
    private final Nombre nombre;


    public ActualizarNombreCommand(ClaseId claseId, Nombre nombre) {
        this.claseId = claseId;
        this.nombre = nombre;
    }

    public ClaseId getClaseId() {
        return claseId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
