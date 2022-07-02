package co.com.example.compania.bailarin.commands;

import co.com.example.compania.bailarin.values.BailarinId;
import co.com.example.compania.bailarin.values.Email;
import co.com.example.compania.bailarin.values.Nombre;
import co.com.example.compania.bailarin.values.Telefono;
import co.com.sofka.domain.generic.Command;

public class CrearBailarin extends Command {
    private final BailarinId entityId;
    private final Nombre nombre;
    private final Telefono telefono;
    private final Email email;

    public CrearBailarin(BailarinId entityId, Nombre nombre, Telefono telefono, Email email) {
        this.entityId = entityId;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    public BailarinId getEntityId() {
        return entityId;
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
