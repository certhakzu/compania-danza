package co.com.sofka.compania.bailarin.events;

import co.com.sofka.compania.bailarin.values.Email;
import co.com.sofka.compania.bailarin.values.Nombre;
import co.com.sofka.compania.bailarin.values.Telefono;
import co.com.sofka.domain.generic.DomainEvent;

public class BailarinCreado extends DomainEvent {

    private Nombre nombre;
    private Telefono telefono;
    private Email email;

    public BailarinCreado(Nombre nombre, Telefono telefono, Email email) {
        super("co.com.sofka.compania.bailarin.bailarincreado");
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public Email getEmail() {
        return email;
    }
}
