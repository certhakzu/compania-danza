package co.com.sofka.compania.ensayo.commands;

import co.com.sofka.compania.ensayo.values.FechaProgramadaId;
import co.com.sofka.domain.generic.Command;

public class CambiarFechaProgramada extends Command {
    private final FechaProgramadaId fechaProgramadaId;

    public CambiarFechaProgramada(FechaProgramadaId fechaProgramadaId) {
        this.fechaProgramadaId = fechaProgramadaId;
    }

    public FechaProgramadaId getFechaProgramadaId() {
        return fechaProgramadaId;
    }
}
