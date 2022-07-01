package co.com.sofka.compania.clase.commands;

import co.com.sofka.compania.clase.values.HoraDeFinal;
import co.com.sofka.compania.clase.values.HoraDeInicio;
import co.com.sofka.domain.generic.Command;

public class CambiarHorasDeClase extends Command {

    private final HoraDeInicio horaDeInicio;
    private final HoraDeFinal horaDeFinal;

    public CambiarHorasDeClase(HoraDeInicio horaDeInicio, HoraDeFinal horaDeFinal) {
        this.horaDeInicio = horaDeInicio;
        this.horaDeFinal = horaDeFinal;
    }

    public HoraDeFinal getHoraDeFinal() {
        return horaDeFinal;
    }

    public HoraDeInicio getHoraDeInicio() {
        return horaDeInicio;
    }
}
