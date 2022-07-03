package co.com.example.compania.ensayo.commands;

import co.com.example.compania.ensayo.values.Coreografo;
import co.com.example.compania.ensayo.values.ObraId;
import co.com.example.compania.ensayo.values.Sinopsis;
import co.com.sofka.domain.generic.Command;

public class CambiarObraCommand extends Command {

    private final ObraId obraId;
    private final Coreografo coreografo;
    private final Sinopsis sinopsis;

    public CambiarObraCommand(ObraId obraId, Coreografo coreografo, Sinopsis sinopsis) {
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
