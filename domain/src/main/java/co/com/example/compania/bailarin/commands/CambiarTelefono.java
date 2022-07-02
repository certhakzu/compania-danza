package co.com.example.compania.bailarin.commands;

import co.com.example.compania.bailarin.values.Telefono;
import co.com.sofka.domain.generic.Command;

public class CambiarTelefono extends Command {

    private final Telefono telefono;


    public CambiarTelefono(Telefono telefono) {
        this.telefono = telefono;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
