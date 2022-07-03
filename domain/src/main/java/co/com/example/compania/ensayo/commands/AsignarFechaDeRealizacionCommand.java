package co.com.example.compania.ensayo.commands;

import co.com.example.compania.ensayo.values.FechaDeRealizacion;
import co.com.sofka.domain.generic.Command;

public class AsignarFechaDeRealizacionCommand extends Command {
    private final FechaDeRealizacion fechaDeRealizacion;

    public AsignarFechaDeRealizacionCommand(FechaDeRealizacion fechaDeRealizacion) {
        this.fechaDeRealizacion = fechaDeRealizacion;
    }

    public FechaDeRealizacion getFechaDeRealizacion() {
        return fechaDeRealizacion;
    }
}
