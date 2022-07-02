package co.com.example.compania.clase.commands;

import co.com.example.compania.clase.values.FechaProgramadaId;
import co.com.sofka.domain.generic.Command;

public class CambiarFechaProgramadaCommand extends Command {
    private final FechaProgramadaId fechaProgramadaId;

    public CambiarFechaProgramadaCommand(FechaProgramadaId fechaProgramadaId) {
        this.fechaProgramadaId = fechaProgramadaId;
    }

    public FechaProgramadaId getFechaProgramadaId() {
        return fechaProgramadaId;
    }
}
