package co.com.example.compania.clase;

import co.com.example.compania.clase.values.Fecha;
import co.com.example.compania.clase.values.FechaProgramadaId;
import co.com.sofka.domain.generic.Entity;

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
