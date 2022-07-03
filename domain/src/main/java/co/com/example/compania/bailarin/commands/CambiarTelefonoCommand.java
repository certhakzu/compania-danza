package co.com.example.compania.bailarin.commands;

import co.com.example.compania.bailarin.values.BailarinId;
import co.com.example.compania.bailarin.values.Telefono;
import co.com.sofka.domain.generic.Command;

public class CambiarTelefonoCommand extends Command {

    private final BailarinId bailarinId;
    private final Telefono telefono;


    public CambiarTelefonoCommand(BailarinId bailarinId, Telefono telefono) {
        this.bailarinId = bailarinId;
        this.telefono = telefono;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public BailarinId getBailarinId() {
        return bailarinId;
    }
}
