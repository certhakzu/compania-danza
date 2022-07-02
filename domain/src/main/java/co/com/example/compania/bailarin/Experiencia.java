package co.com.example.compania.bailarin;

import co.com.example.compania.bailarin.values.ExperienciaId;
import co.com.example.compania.bailarin.values.Duracion;
import co.com.example.compania.bailarin.values.Estilo;
import co.com.example.compania.bailarin.values.Lugar;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Experiencia extends Entity<ExperienciaId> {

    private Estilo estilo;
    private Lugar lugar;
    private Duracion duracion;
    public Experiencia(ExperienciaId entityId, Estilo estilo, Lugar lugar, Duracion duracion) {
        super(entityId);
        this.estilo = estilo;
        this.lugar = lugar;
        this.duracion = duracion;
    }

    public void actualizarEstilo(Estilo estilo){
        this.estilo = Objects.requireNonNull(estilo);
    }

    public void actualizarLugar(Lugar lugar){
        this.lugar = Objects.requireNonNull(lugar);
    }

    public void actualizarDuracion(Duracion duracion){
        this.duracion = Objects.requireNonNull(duracion);
    }

    public Estilo estilo() {
        return estilo;
    }

    public Lugar lugar() {
        return lugar;
    }

    public Duracion duracion() {
        return duracion;
    }
}
