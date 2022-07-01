package co.com.sofka.compania.ensayo.events;

import co.com.sofka.compania.ensayo.values.Descripcion;
import co.com.sofka.domain.generic.DomainEvent;

public class DescripcionActualizada extends DomainEvent {

    private final Descripcion descripcion;

    public DescripcionActualizada(Descripcion descripcion){
        super("co.com.sofka.compania.ensayo.descripcionactualizada");
        this.descripcion = descripcion;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
