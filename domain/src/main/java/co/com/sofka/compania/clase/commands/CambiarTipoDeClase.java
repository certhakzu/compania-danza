package co.com.sofka.compania.clase.commands;

import co.com.sofka.compania.clase.values.Descripcion;
import co.com.sofka.compania.clase.values.Nombre;
import co.com.sofka.compania.clase.values.TipoDeClaseId;
import co.com.sofka.domain.generic.Command;

public class CambiarTipoDeClase extends Command {

    private final TipoDeClaseId tipoDeClaseId;
    private final Nombre nombre;
    private final Descripcion descripcion;

    public CambiarTipoDeClase(TipoDeClaseId tipoDeClaseId, Nombre nombre, Descripcion descripcion) {
        this.tipoDeClaseId = tipoDeClaseId;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public TipoDeClaseId getTipoDeClaseId() {
        return tipoDeClaseId;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
