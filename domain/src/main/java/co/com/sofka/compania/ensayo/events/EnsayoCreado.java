package co.com.sofka.compania.ensayo.events;

import co.com.sofka.compania.ensayo.values.*;
import co.com.sofka.domain.generic.DomainEvent;

public class EnsayoCreado extends DomainEvent {

    private FechaProgramadaId fechaProgramadaId;
    private ObraId obraId;
    private HoraDeInicio horaDeInicio;
    private HoraDeFinal horaDeFinal;
    private Descripcion descripcion;

    public EnsayoCreado(FechaProgramadaId fechaProgramadaId,
                        ObraId obraId,
                        HoraDeInicio horaDeInicio,
                        HoraDeFinal horaDeFinal,
                        Descripcion descripcion) {
        super("co.com.sofka.compania.ensayo.ensayocreado");
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
