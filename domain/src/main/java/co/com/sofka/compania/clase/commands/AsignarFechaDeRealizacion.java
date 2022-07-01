package co.com.sofka.compania.clase.commands;

import co.com.sofka.compania.clase.values.FechaDeRealizacion;
import co.com.sofka.domain.generic.Command;

public class AsignarFechaDeRealizacion extends Command {

    private final FechaDeRealizacion fechaDeRealizacion;

    public AsignarFechaDeRealizacion(FechaDeRealizacion fechaDeRealizacion) {
        this.fechaDeRealizacion = fechaDeRealizacion;
    }

    public FechaDeRealizacion getFechaDeRealizacion() {
        return fechaDeRealizacion;
    }
}