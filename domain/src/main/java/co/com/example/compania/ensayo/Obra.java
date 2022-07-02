package co.com.example.compania.ensayo;

import co.com.example.compania.ensayo.values.*;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Obra extends Entity<ObraId> {

    private Coreografo coreografo;
    private Sinopsis sinopsis;
    private Duracion duracion;
    private Musica musica;
    private FechaProgramadaDeEstreno fechaProgramadaDeEstreno;
    private FechaDeEstreno fechaDeEstreno;

    public Obra(ObraId obraId, Coreografo coreografo, Sinopsis sinopsis){
        super(obraId);
        this.coreografo = coreografo;
        this.sinopsis = sinopsis;
    }

    public void actualizarDuracion(Duracion duracion){
        this.duracion = Objects.requireNonNull(duracion);
    }

    public void actualizarMusica(Musica musica){
        this.musica = Objects.requireNonNull(musica);
    }

    public void asignarFechaProgramadaDeEstreno(FechaProgramadaDeEstreno fechaProgramadaDeEstreno){
        this.fechaProgramadaDeEstreno = Objects.requireNonNull(fechaProgramadaDeEstreno);
    }

    public void asignarFechaDeEstreno(FechaDeEstreno fechaDeEstreno){
        this.fechaDeEstreno = Objects.requireNonNull(fechaDeEstreno);
    }

    public void actualizarCoreografo(Coreografo coreografo){
        this.coreografo = Objects.requireNonNull(coreografo);
    }

    public void actualizarSinopsis(Sinopsis sinopsis){
        this.sinopsis = Objects.requireNonNull(sinopsis);
    }

    public Coreografo getCoreografo() {
        return coreografo;
    }

    public Sinopsis getSinopsis() {
        return sinopsis;
    }

    public Duracion getDuracion() {
        return duracion;
    }

    public Musica getMusica() {
        return musica;
    }

    public FechaProgramadaDeEstreno getFechaProgramadaDeEstreno() {
        return fechaProgramadaDeEstreno;
    }

    public FechaDeEstreno getFechaDeEstreno() {
        return fechaDeEstreno;
    }
}
