package co.com.sofka.compania.clase.events;

import co.com.sofka.compania.clase.values.Descripcion;
import co.com.sofka.compania.clase.values.Nombre;
import co.com.sofka.compania.clase.values.TipoDeClaseId;
import co.com.sofka.domain.generic.DomainEvent;

public class TipoDeClaseCambiado extends DomainEvent {

    private TipoDeClaseId tipoDeClaseId;
    private Nombre nombre;
    private Descripcion descripcion;

    public TipoDeClaseCambiado(TipoDeClaseId tipoDeClaseId, Nombre nombre, Descripcion descripcion) {
        super("co.com.sofka.compania.clase.tipodeclasecambiado");
    }

    public TipoDeClaseId getTipoDeClaseId() {
        return tipoDeClaseId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
