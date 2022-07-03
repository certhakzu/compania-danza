package co.com.example.compania.bailarin.commands;

import co.com.example.compania.bailarin.values.BailarinId;
import co.com.example.compania.bailarin.values.Nombre;
import co.com.sofka.domain.generic.Command;

public class CambiarNombreCommand extends Command {

    private final BailarinId bailarinId;
    private final Nombre nombre;

    public CambiarNombreCommand(BailarinId bailarinId, Nombre nombre) {
        this.bailarinId = bailarinId;
        this.nombre = nombre;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public BailarinId getBailarinId() {
        return bailarinId;
    }

}
