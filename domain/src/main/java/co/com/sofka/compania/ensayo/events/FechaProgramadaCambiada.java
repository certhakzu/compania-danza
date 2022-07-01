package co.com.sofka.compania.ensayo.events;

import co.com.sofka.compania.ensayo.values.FechaProgramadaId;
import co.com.sofka.domain.generic.DomainEvent;

public class FechaProgramadaCambiada extends DomainEvent {

    private FechaProgramadaId fechaProgramadaId;

    public FechaProgramadaCambiada(FechaProgramadaId fechaProgramadaId){
        super("co.com.sofka.compania.ensayo.fechaprogramadacambiada");
        this.fechaProgramadaId = fechaProgramadaId;
    }

    public FechaProgramadaId getFechaProgramadaId() {
        return fechaProgramadaId;
    }
}
