package co.com.example.compania.bailarin.events;

import co.com.example.compania.bailarin.values.Telefono;
import co.com.sofka.domain.generic.DomainEvent;

public class TelefonoCambiado extends DomainEvent {

    private final Telefono telefono;

    public TelefonoCambiado(Telefono telefono) {
        super("co.com.sofka.compania.bailarin.telefonocambiado");
        this.telefono = telefono;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
