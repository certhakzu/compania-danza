package co.com.example.compania.ensayo.commands;

import co.com.example.compania.ensayo.values.Descripcion;
import co.com.example.compania.ensayo.values.EnsayoId;
import co.com.sofka.domain.generic.Command;

public class ActualizarDescripcionCommand extends Command {

    private final EnsayoId ensayoId;

    private final Descripcion descripcion;


    public ActualizarDescripcionCommand(EnsayoId ensayoId, Descripcion descripcion) {
        this.ensayoId = ensayoId;
        this.descripcion = descripcion;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public EnsayoId getEnsayoId() {
        return ensayoId;
    }
}
