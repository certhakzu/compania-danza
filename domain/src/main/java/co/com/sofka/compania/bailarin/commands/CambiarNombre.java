package co.com.sofka.compania.bailarin.commands;

import co.com.sofka.compania.bailarin.values.Nombre;
import co.com.sofka.domain.generic.Command;

public class CambiarNombre extends Command {

    private final Nombre nombre;

    public CambiarNombre(Nombre nombre) {
        this.nombre = nombre;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
