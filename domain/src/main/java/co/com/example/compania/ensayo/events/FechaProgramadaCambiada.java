package co.com.example.compania.ensayo.events;

import co.com.example.compania.ensayo.values.FechaProgramadaId;
import co.com.sofka.domain.generic.DomainEvent;

public class FechaProgramadaCambiada extends DomainEvent {

    private final FechaProgramadaId fechaProgramadaId;

    public FechaProgramadaCambiada(FechaProgramadaId fechaProgramadaId){
        super("co.com.sofka.compania.ensayo.fechaprogramadacambiada");
        this.fechaProgramadaId = fechaProgramadaId;
    }

    public FechaProgramadaId getFechaProgramadaId() {
        return fechaProgramadaId;
    }
}
