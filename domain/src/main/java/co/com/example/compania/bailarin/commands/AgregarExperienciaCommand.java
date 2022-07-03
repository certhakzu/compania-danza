package co.com.example.compania.bailarin.commands;

import co.com.example.compania.bailarin.values.*;
import co.com.sofka.domain.generic.Command;

public class AgregarExperienciaCommand extends Command {

    private final BailarinId bailarinId;
    private final ExperienciaId entityId;
    private final Estilo estilo;
    private final Lugar lugar;
    private final Duracion duracion;

    public AgregarExperienciaCommand(BailarinId bailarinId, ExperienciaId entityId, Estilo estilo, Lugar lugar, Duracion duracion) {
        this.bailarinId = bailarinId;
        this.entityId = entityId;
        this.estilo = estilo;
        this.lugar = lugar;
        this.duracion = duracion;
    }

    public BailarinId getBailarinId() {
        return bailarinId;
    }

    public ExperienciaId getEntityId() {
        return entityId;
    }

    public Estilo getEstilo() {
        return estilo;
    }

    public Lugar getLugar() {
        return lugar;
    }

    public Duracion getDuracion() {
        return duracion;
    }
}
