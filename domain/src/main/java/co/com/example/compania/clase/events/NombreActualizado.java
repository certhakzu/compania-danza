package co.com.example.compania.clase.events;

import co.com.example.compania.clase.values.Nombre;
import co.com.sofka.domain.generic.DomainEvent;

public class NombreActualizado extends DomainEvent {
    private final Nombre nombre;

    public NombreActualizado(Nombre nombre) {
        super("co.com.sofka.compania.clase.nombreactualizado");
        this.nombre = nombre;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
