package co.com.sofka.compania.ensayo.events;

import co.com.sofka.compania.ensayo.values.Duracion;
import co.com.sofka.domain.generic.DomainEvent;

public class DuracionDeObraActualizada extends DomainEvent {

    private Duracion duracion;

    public DuracionDeObraActualizada(Duracion duracion){
        super("co.com.sofka.compania.ensayo.duraciondeobraactualizada");
        this.duracion = duracion;
    }

    public Duracion getDuracion() {
        return duracion;
    }
}
