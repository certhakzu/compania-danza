package co.com.sofka.compania.bailarin;

import co.com.sofka.compania.bailarin.events.*;
import co.com.sofka.compania.bailarin.values.*;
import co.com.sofka.compania.clase.values.ClaseId;
import co.com.sofka.compania.clase.values.FechaDeRealizacion;
import co.com.sofka.domain.generic.AggregateEvent;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Bailarin extends AggregateEvent<BailarinId> {

    protected Nombre nombre;
    protected Telefono telefono;
    protected Email email;
    protected Set<ClaseRealizada> claseRealizadas;
    protected List<Experiencia> experiencias;

    public Bailarin(BailarinId entityId, Nombre nombre, Telefono telefono, Email email) {
        super(entityId);
        appendChange(new BailarinCreado(nombre, telefono, email)).apply();
    }

    public void agregarExperiencia(ExperienciaId entityId, Estilo estilo, Lugar lugar, Duracion duracion){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(estilo);
        Objects.requireNonNull(lugar);
        Objects.requireNonNull(duracion);
        appendChange(new ExperienciaAgregada(entityId, estilo, lugar, duracion)).apply();;
    }

    public void eliminarExperiencia(ExperienciaId experienciaId){
        Objects.requireNonNull(experienciaId);
        appendChange(new ExperienciaEliminada(experienciaId)).apply();
    }

    public void cambiarNombre(Nombre nombre){
        Objects.requireNonNull(nombre);
        appendChange(new NombreCambiado(nombre)).apply();
    }

    public void cambiarTelefono(Telefono telefono){
        Objects.requireNonNull(telefono);
        appendChange(new TelefonoCambiado(telefono)).apply();
    }

    public void cambiarEmail(Email email){
        Objects.requireNonNull(email);
        appendChange(new EmailCambiado(email)).apply();
    }

    public void agregarClaseRealizada(ClaseRealizadaId entityId, ClaseId claseId, FechaDeRealizacion fechaDeRealizacion){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(claseId);
        Objects.requireNonNull(fechaDeRealizacion);
        appendChange(new ClaseRealizadaAgregada(entityId, claseId, fechaDeRealizacion));
    }

    public void eliminarClaseRealizada(ClaseRealizadaId entityId){
        Objects.requireNonNull(entityId);
        appendChange(new ClaseRealizadaEliminada(entityId)).apply();
    }

    public Optional<Experiencia> getExperienciaPorId(ExperienciaId experienciaId){
        return experiencias()
                .stream()
                .filter(experiencia -> experiencia.identity().equals(experienciaId))
                .findFirst();
    }

    public Nombre nombre() {
        return nombre;
    }

    public Telefono telefono() {
        return telefono;
    }

    public Email email() {
        return email;
    }

    public Set<ClaseRealizada> claseRealizadas() {
        return claseRealizadas;
    }

    public List<Experiencia> experiencias() {
        return experiencias;
    }
}
