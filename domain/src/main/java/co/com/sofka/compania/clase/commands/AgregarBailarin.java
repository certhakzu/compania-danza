package co.com.sofka.compania.clase.commands;

import co.com.sofka.compania.bailarin.values.BailarinId;
import co.com.sofka.compania.bailarin.values.Email;
import co.com.sofka.compania.bailarin.values.Nombre;
import co.com.sofka.compania.bailarin.values.Telefono;
import co.com.sofka.domain.generic.Command;

public class AgregarBailarin extends Command {

    private final BailarinId bailarinId;
    private final Nombre nombre;
    private final Telefono telefono;
    private final Email email;

    public AgregarBailarin(BailarinId bailarinId, Nombre nombre, Telefono telefono, Email email) {
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
