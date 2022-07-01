package co.com.sofka.compania.clase.events;

import co.com.sofka.compania.bailarin.values.BailarinId;
import co.com.sofka.compania.bailarin.values.Email;
import co.com.sofka.compania.bailarin.values.Telefono;
import co.com.sofka.compania.bailarin.values.Nombre;
import co.com.sofka.domain.generic.DomainEvent;

public class BailarinAgregado extends DomainEvent {

    private BailarinId bailarinId;
    private Nombre nombre;
    private Telefono telefono;
    private Email email;

    public BailarinAgregado(BailarinId bailarinId,Nombre nombre,Telefono telefono,Email email) {
        super("co.com.sofka.compania.clase.bailarinagregado");
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