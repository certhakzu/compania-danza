package co.com.example.compania.clase.events;

import co.com.example.compania.bailarin.values.BailarinId;
import co.com.example.compania.bailarin.values.Email;
import co.com.example.compania.bailarin.values.Nombre;
import co.com.example.compania.bailarin.values.Telefono;
import co.com.example.compania.clase.values.ClaseId;
import co.com.sofka.domain.generic.DomainEvent;

public class BailarinAgregado extends DomainEvent {

    private ClaseId claseId;

    private BailarinId bailarinId;
    private Nombre nombre;
    private Telefono telefono;
    private Email email;

    public BailarinAgregado(ClaseId claseId, BailarinId bailarinId,Nombre nombre,Telefono telefono,Email email) {
        super("co.com.example.compania.clase.bailarinagregado");
        this.claseId = claseId;
        this.bailarinId = bailarinId;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    public ClaseId getClaseId() {
        return claseId;
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
