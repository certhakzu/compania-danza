package co.com.sofka.compania.ensayo.events;

import co.com.sofka.compania.ensayo.values.ObraId;
import co.com.sofka.domain.generic.DomainEvent;

public class ObraCambiada extends DomainEvent {

    private ObraId obraId;

    public ObraCambiada(ObraId obraId) {
        super("co.com.sofka.compania.ensayo.obracambiada");
        this.obraId = obraId;
    }

    public ObraId getObraId() {
        return obraId;
    }
}
