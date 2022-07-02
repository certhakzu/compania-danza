package co.com.sofka.compania.ensayo.commands;

import co.com.sofka.compania.ensayo.values.Descripcion;
import co.com.sofka.domain.generic.Command;

public class ActualizarDescripcion extends Command {

    private final Descripcion descripcion;


    public ActualizarDescripcion(Descripcion descripcion) {
        this.descripcion = descripcion;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
