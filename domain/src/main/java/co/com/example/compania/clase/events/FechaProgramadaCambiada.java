package co.com.example.compania.clase.events;

import co.com.example.compania.clase.values.Fecha;
import co.com.example.compania.clase.values.FechaProgramadaId;
import co.com.sofka.domain.generic.DomainEvent;

public class FechaProgramadaCambiada extends DomainEvent {

    private final FechaProgramadaId fechaProgramadaId;
    private final Fecha fechaProgramada;

    public FechaProgramadaCambiada(FechaProgramadaId fechaProgramadaId, Fecha fechaProgramada) {
        super("co.com.sofka.compania.clase.fechaprogramadacambiada");
        this.fechaProgramadaId = fechaProgramadaId;
        this.fechaProgramada = fechaProgramada;
    }

    public FechaProgramadaId getFechaProgramadaId() {
        return fechaProgramadaId;
    }
}
