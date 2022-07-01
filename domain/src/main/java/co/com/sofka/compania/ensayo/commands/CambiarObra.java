package co.com.sofka.compania.ensayo.commands;

import co.com.sofka.compania.ensayo.values.Coreografo;
import co.com.sofka.compania.ensayo.values.ObraId;
import co.com.sofka.compania.ensayo.values.Sinopsis;
import co.com.sofka.domain.generic.Command;

public class CambiarObra extends Command {

    private final ObraId obraId;
    private final Coreografo coreografo;
    private final Sinopsis sinopsis;

    public CambiarObra(ObraId obraId, Coreografo coreografo, Sinopsis sinopsis) {
        this.obraId = obraId;
        this.coreografo = coreografo;
        this.sinopsis = sinopsis;
    }

    public ObraId getObraId() {
        return obraId;
    }

    public Coreografo getCoreografo() {
        return coreografo;
    }

    public Sinopsis getSinopsis() {
        return sinopsis;
    }
}
