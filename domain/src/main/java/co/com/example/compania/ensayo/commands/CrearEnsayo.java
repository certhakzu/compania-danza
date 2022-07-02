package co.com.example.compania.ensayo.commands;

import co.com.example.compania.ensayo.values.*;
import co.com.sofka.domain.generic.Command;

public class CrearEnsayo extends Command {

    private final FechaProgramadaId fechaProgramadaId;
    private final ObraId obraId;
    private final HoraDeInicio horaDeInicio;
    private final HoraDeFinal horaDeFinal;
    private final Descripcion descripcion;

    public CrearEnsayo(FechaProgramadaId fechaProgramadaId,
                       ObraId obraId,
                       HoraDeInicio horaDeInicio,
                       HoraDeFinal horaDeFinal,
                       Descripcion descripcion) {
        this.fechaProgramadaId = fechaProgramadaId;
        this.obraId = obraId;
        this.horaDeInicio = horaDeInicio;
        this.horaDeFinal = horaDeFinal;
        this.descripcion = descripcion;
    }

    public FechaProgramadaId getFechaProgramadaId() {
        return fechaProgramadaId;
    }

    public ObraId getObraId() {
        return obraId;
    }

    public HoraDeInicio getHoraDeInicio() {
        return horaDeInicio;
    }

    public HoraDeFinal getHoraDeFinal() {
        return horaDeFinal;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
