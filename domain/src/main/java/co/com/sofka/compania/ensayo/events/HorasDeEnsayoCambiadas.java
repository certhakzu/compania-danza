package co.com.sofka.compania.ensayo.events;

import co.com.sofka.compania.ensayo.values.HoraDeFinal;
import co.com.sofka.compania.ensayo.values.HoraDeInicio;
import co.com.sofka.domain.generic.DomainEvent;

public class HorasDeEnsayoCambiadas extends DomainEvent {

    private final HoraDeInicio horaDeInicio;
    private final HoraDeFinal horaDeFinal;

    public HorasDeEnsayoCambiadas(HoraDeInicio horaDeInicio, HoraDeFinal horaDeFinal){
        super("co.com.sofka.compania.ensayo.horasdeensayocambiadas");
        this.horaDeInicio = horaDeInicio;
        this.horaDeFinal = horaDeFinal;
    }

    public HoraDeInicio getHoraDeInicio() {
        return horaDeInicio;
    }

    public HoraDeFinal getHoraDeFinal() {
        return horaDeFinal;
    }
}
