package co.com.example.compania.clase.events;

import co.com.example.compania.clase.values.HoraDeFinal;
import co.com.example.compania.clase.values.HoraDeInicio;
import co.com.sofka.domain.generic.DomainEvent;

public class HorasDeClaseCambiadas extends DomainEvent {

    private final HoraDeInicio horaDeInicio;
    private final HoraDeFinal horaDeFinal;


    public HorasDeClaseCambiadas(HoraDeInicio horaDeInicio, HoraDeFinal horaDeFinal) {
        super("co.com.sofka.compania.clase.horasdeclasecambiadas");
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
