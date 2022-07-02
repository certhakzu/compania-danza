package co.com.example.compania.ensayo;

import co.com.example.compania.bailarin.values.BailarinId;
import co.com.example.compania.bailarin.values.Email;
import co.com.example.compania.bailarin.values.Nombre;
import co.com.example.compania.bailarin.values.Telefono;
import co.com.example.compania.ensayo.events.*;
import co.com.example.compania.ensayo.values.*;
import co.com.example.compania.bailarin.Bailarin;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Ensayo extends AggregateEvent<EnsayoId> {

    protected FechaProgramadaId fechaProgramadaId;
    protected ObraId obraId;
    protected Set<Bailarin> bailarines;
    protected HoraDeInicio horaDeInicio;
    protected HoraDeFinal horaDeFinal;
    protected Descripcion descripcion;
    protected FechaDeRealizacion fechaDeRealizacion;

    public Ensayo(EnsayoId entityId,
                  FechaProgramadaId fechaProgramadaId,
                  ObraId obraId,
                  HoraDeInicio horaDeInicio,
                  HoraDeFinal horaDeFinal,
                  Descripcion descripcion) {
        super(entityId);
        appendChange(new EnsayoCreado(fechaProgramadaId, obraId, horaDeInicio, horaDeFinal, descripcion)).apply();
        subscribe(new EnsayoChange(this));
    }

    /**
     * Cuando el Agregado está creado
     */
    public Ensayo(EnsayoId entityId){
        super(entityId);
        subscribe(new EnsayoChange(this));
    }

    /**
     * Cuando quiero construir el Agregado (es decir que ya existe)
     * Es una factoria
     */
    public static Ensayo from(EnsayoId ensayoId, List<DomainEvent> events){
        var ensayo = new Ensayo(ensayoId);
        events.forEach(ensayo::applyEvent);// como ya debe existir un suscriptor y una lista de eventos, recrea los agregados que ya estan guardados
        return ensayo;
    }

    public void agregarBailarin(BailarinId entityId, Nombre nombre, Telefono telefono, Email email){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(telefono);
        Objects.requireNonNull(email);
        appendChange(new BailarinAgregado(entityId, nombre, telefono, email)).apply();
    }

    public void eliminarBailarin(BailarinId bailarinId){
        Objects.requireNonNull(bailarinId);
        appendChange(new BailarinEliminado(bailarinId)).apply();
    }

    public void cambiarHorasDeEnsayo(HoraDeInicio horaDeInicio, HoraDeFinal horaDeFinal){
        Objects.requireNonNull(horaDeInicio);
        Objects.requireNonNull(horaDeFinal);
        appendChange(new HorasDeEnsayoCambiadas(horaDeInicio, horaDeFinal)).apply();
    }

    public void actualizarDescripcion(Descripcion descripcion){
        Objects.requireNonNull(descripcion);
        appendChange(new DescripcionActualizada(descripcion)).apply();
    }

    public void cambiarFehcaProgramada(FechaProgramadaId fechaProgramadaId){
        Objects.requireNonNull(fechaProgramadaId);
        appendChange(new FechaProgramadaCambiada(fechaProgramadaId)).apply();
    }

    public void cambiarObra(ObraId obraId){
        Objects.requireNonNull(obraId);
        appendChange(new ObraCambiada(obraId)).apply();
    }

    public void asignarFechaDeRealizacion(FechaDeRealizacion fechaDeRealizacion){
        Objects.requireNonNull(fechaDeRealizacion);
        appendChange(new FechaDeRealizacionAsignada(fechaDeRealizacion)).apply();
    }



    protected Optional<Bailarin> getBailarinPorId(BailarinId bailarinId){
        return bailarines()
                .stream()
                .filter(bailarin -> bailarin.identity().equals(bailarinId))
                .findFirst();
    }

    public FechaProgramadaId fechaProgramadaId() {
        return fechaProgramadaId;
    }

    public ObraId obraId() {
        return obraId;
    }

    public Set<Bailarin> bailarines() {
        return bailarines;
    }

    public HoraDeInicio horaDeInicio() {
        return horaDeInicio;
    }

    public HoraDeFinal horaDeFinal() {
        return horaDeFinal;
    }

    public Descripcion descripcion() {
        return descripcion;
    }

    public FechaDeRealizacion fechaDeRealizacion() {
        return fechaDeRealizacion;
    }
}
