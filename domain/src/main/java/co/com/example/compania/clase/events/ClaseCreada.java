package co.com.example.compania.clase.events;

import co.com.example.compania.bailarin.Bailarin;
import co.com.example.compania.clase.values.*;
import co.com.sofka.domain.generic.DomainEvent;

public class ClaseCreada extends DomainEvent {

    private TipoDeClaseId tipoDeClaseId;
    private FechaProgramadaId fechaProgramadaId;
    private HoraDeInicio horaDeInicio;
    private HoraDeFinal horaDeFinal;
    private Nombre nombre;
    private Bailarin profesor;


    public ClaseCreada(TipoDeClaseId tipoDeClaseId,
                       FechaProgramadaId fechaProgramadaId,
                       HoraDeInicio horaDeInicio,
                       HoraDeFinal horaDeFinal,
                       Nombre nombre,
                       Bailarin profesor) {
        super("co.com.sofka.compania.clase.clasecreada");
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
