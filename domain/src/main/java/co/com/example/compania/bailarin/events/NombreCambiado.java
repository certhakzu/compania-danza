package co.com.example.compania.bailarin.events;

import co.com.example.compania.bailarin.values.Nombre;
import co.com.sofka.domain.generic.DomainEvent;

public class NombreCambiado extends DomainEvent {

    private final Nombre nombre;

    public NombreCambiado(Nombre nombre) {
        super("co.com.sofka.compania.bailarin.nombrecambiado");
        this.nombre = nombre;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
