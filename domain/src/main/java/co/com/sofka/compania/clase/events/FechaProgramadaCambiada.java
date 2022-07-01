package co.com.sofka.compania.clase.events;

import co.com.sofka.compania.clase.FechaProgramada;

import co.com.sofka.domain.generic.DomainEvent;

public class FechaProgramadaCambiada extends DomainEvent {

    private final FechaProgramada fechaProgramada;

    public FechaProgramadaCambiada(FechaProgramada fechaProgramada) {
        super("co.com.sofka.compania.clase.fechaprogramadacambiada");
        this.fechaProgramada = fechaProgramada;
    }

    public FechaProgramada getFechaProgramada() {
        return fechaProgramada;
    }
}
