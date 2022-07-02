package co.com.example.compania.clase.commands;

import co.com.example.compania.clase.values.HoraDeFinal;
import co.com.example.compania.clase.values.HoraDeInicio;
import co.com.sofka.domain.generic.Command;

public class CambiarHorasDeClaseCommand extends Command {

    private final HoraDeInicio horaDeInicio;
    private final HoraDeFinal horaDeFinal;

    public CambiarHorasDeClaseCommand(HoraDeInicio horaDeInicio, HoraDeFinal horaDeFinal) {
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
