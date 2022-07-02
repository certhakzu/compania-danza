package co.com.sofka.compania.clase;

import co.com.sofka.compania.clase.values.Descripcion;
import co.com.sofka.compania.clase.values.Nombre;
import co.com.sofka.compania.clase.values.TipoDeClaseId;
import co.com.sofka.domain.generic.Entity;

public class TipoDeClase extends Entity<TipoDeClaseId> {

    private Nombre nombre;
    private Descripcion descripcion;

    public TipoDeClase(TipoDeClaseId tipoDeClaseId, Nombre nombre, Descripcion descripcion){
        super(tipoDeClaseId);
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public void cambiarNombre(Nombre nombre){
        this.nombre = nombre;
    }

    public void actualizarDescripcion(Descripcion descripcion){
        this.descripcion = descripcion;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
