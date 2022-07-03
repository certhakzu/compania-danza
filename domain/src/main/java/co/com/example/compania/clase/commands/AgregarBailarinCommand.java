package co.com.example.compania.clase.commands;

import co.com.example.compania.bailarin.values.BailarinId;
import co.com.example.compania.bailarin.values.Email;
import co.com.example.compania.bailarin.values.Nombre;
import co.com.example.compania.bailarin.values.Telefono;
import co.com.example.compania.clase.values.ClaseId;
import co.com.sofka.domain.generic.Command;

public class AgregarBailarinCommand extends Command {

    private final ClaseId claseId;
    private final BailarinId bailarinId;
    private final Nombre nombre;
    private final Telefono telefono;
    private final Email email;

    public AgregarBailarinCommand(ClaseId claseId, BailarinId bailarinId, Nombre nombre, Telefono telefono, Email email) {
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
