package co.com.sofka.compania.bailarin;

import co.com.sofka.compania.bailarin.values.ClaseRealizadaId;
import co.com.sofka.compania.clase.values.ClaseId;
import co.com.sofka.compania.clase.values.FechaDeRealizacion;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class ClaseRealizada extends Entity<ClaseRealizadaId> {

    private ClaseId claseId;
    private FechaDeRealizacion fechaDeRealizacion;

    public ClaseRealizada(ClaseRealizadaId entityId, ClaseId claseId, FechaDeRealizacion fechaDeRealizacion) {
        super(entityId);
        this.claseId = claseId;
        this.fechaDeRealizacion = fechaDeRealizacion;
    }

    public void actualizarFechaDeRealizacion(FechaDeRealizacion fechaDeRealizacion){
        this.fechaDeRealizacion = Objects.requireNonNull(fechaDeRealizacion);
    }

    public void actualizarClase(ClaseId claseId){
        this.claseId = Objects.requireNonNull(claseId);
    }

    public ClaseId claseIdlaseId() {
        return claseId;
    }

    public FechaDeRealizacion fechaDeRealizacion() {
        return fechaDeRealizacion;
    }
}
