package co.com.sofka.compania.clase;

import co.com.sofka.compania.clase.values.Fecha;
import co.com.sofka.compania.clase.values.FechaProgramadaId;
import co.com.sofka.domain.generic.Entity;

import java.time.LocalDate;

public class FechaProgramada extends Entity<FechaProgramadaId> {

    private Fecha fecha;

    public FechaProgramada(FechaProgramadaId entityId, Fecha fecha) {
        super(entityId);
        this.fecha = fecha;
    }

    public void cambiarFecha(Fecha fecha){
        this.fecha = fecha;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
