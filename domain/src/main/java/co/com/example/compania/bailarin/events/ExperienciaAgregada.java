package co.com.example.compania.bailarin.events;

import co.com.example.compania.bailarin.values.Duracion;
import co.com.example.compania.bailarin.values.Estilo;
import co.com.example.compania.bailarin.values.ExperienciaId;
import co.com.example.compania.bailarin.values.Lugar;
import co.com.sofka.domain.generic.DomainEvent;

public class ExperienciaAgregada extends DomainEvent {

    private ExperienciaId experienciaId;
    private Estilo estilo;
    private Lugar lugar;
    private Duracion duracion;

    public ExperienciaAgregada(ExperienciaId experienciaId, Estilo estilo, Lugar lugar, Duracion duracion) {
        super("co.com.sofka.compania.bailarin.experienciaagregada");
        this.experienciaId = experienciaId;
        this.estilo = estilo;
        this.lugar = lugar;
        this.duracion = duracion;
    }

    public ExperienciaId getExperienciaId(){
        return experienciaId;
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
