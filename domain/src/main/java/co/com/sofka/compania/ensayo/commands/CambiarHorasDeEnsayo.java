package co.com.sofka.compania.ensayo.commands;

import co.com.sofka.compania.ensayo.values.HoraDeFinal;
import co.com.sofka.compania.ensayo.values.HoraDeInicio;
import co.com.sofka.domain.generic.Command;

public class CambiarHorasDeEnsayo extends Command {
    private final HoraDeInicio horaDeInicio;
    private final HoraDeFinal horaDeFinal;

    public CambiarHorasDeEnsayo(HoraDeInicio horaDeInicio, HoraDeFinal horaDeFinal) {
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
