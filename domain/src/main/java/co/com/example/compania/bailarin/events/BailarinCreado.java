package co.com.example.compania.bailarin.events;

import co.com.example.compania.bailarin.values.BailarinId;
import co.com.example.compania.bailarin.values.Email;
import co.com.example.compania.bailarin.values.Nombre;
import co.com.example.compania.bailarin.values.Telefono;
import co.com.sofka.domain.generic.DomainEvent;

public class BailarinCreado extends DomainEvent {

    private BailarinId bailarinId;
    private Nombre nombre;
    private Telefono telefono;
    private Email email;

    public BailarinCreado(BailarinId bailarinId, Nombre nombre, Telefono telefono, Email email) {
        super("co.com.example.compania.bailarin.bailarincreado");
        this.bailarinId = bailarinId;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    public BailarinId getBailarinId() {
        return bailarinId;
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
