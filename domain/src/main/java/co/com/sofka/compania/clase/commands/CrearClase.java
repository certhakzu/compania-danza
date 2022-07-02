package co.com.sofka.compania.clase.commands;

import co.com.sofka.compania.bailarin.Bailarin;
import co.com.sofka.compania.clase.values.*;
import co.com.sofka.domain.generic.Command;

public class CrearClase extends Command {

    private final TipoDeClaseId tipoDeClaseId;
    private final FechaProgramadaId fechaProgramadaId;
    private final HoraDeInicio horaDeInicio;
    private final HoraDeFinal horaDeFinal;
    private final Nombre nombre;
    private final Bailarin profesor;

    public CrearClase(TipoDeClaseId tipoDeClaseId,
                      FechaProgramadaId fechaProgramadaId,
                      HoraDeInicio horaDeInicio,
                      HoraDeFinal horaDeFinal,
                      Nombre nombre,
                      Bailarin profesor) {
        this.tipoDeClaseId = tipoDeClaseId;
        this.fechaProgramadaId = fechaProgramadaId;
        this.horaDeInicio = horaDeInicio;
        this.horaDeFinal = horaDeFinal;
        this.nombre = nombre;
        this.profesor = profesor;
    }

    public TipoDeClaseId getTipoDeClaseId() {
        return tipoDeClaseId;
    }

    public FechaProgramadaId getFechaProgramadaId() {
        return fechaProgramadaId;
    }

    public HoraDeInicio getHoraDeInicio() {
        return horaDeInicio;
    }

    public HoraDeFinal getHoraDeFinal() {
        return horaDeFinal;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Bailarin getProfesor() {
        return profesor;
    }
}
