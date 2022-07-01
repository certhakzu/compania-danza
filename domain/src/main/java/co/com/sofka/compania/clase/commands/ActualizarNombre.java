package co.com.sofka.compania.clase.commands;

import co.com.sofka.compania.clase.values.Nombre;
import co.com.sofka.domain.generic.Command;

public class ActualizarNombre extends Command {

    private final Nombre nombre;


    public ActualizarNombre(Nombre nombre) {
        this.nombre = nombre;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
