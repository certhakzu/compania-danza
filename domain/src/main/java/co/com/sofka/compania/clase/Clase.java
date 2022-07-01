package co.com.sofka.compania.clase;

import co.com.sofka.compania.bailarin.Bailarin;
import co.com.sofka.compania.bailarin.values.BailarinId;
import co.com.sofka.compania.bailarin.values.Email;
import co.com.sofka.compania.bailarin.values.Telefono;
import co.com.sofka.compania.clase.events.*;
import co.com.sofka.compania.clase.values.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Clase extends AggregateEvent<ClaseId> {

    protected TipoDeClaseId tipoDeClaseId;
    protected FechaProgramadaId fechaProgramadaId;
    protected HoraDeInicio horaDeInicio;
    protected HoraDeFinal horaDeFinal;
    protected Nombre nombre;
    protected FechaDeRealizacion fechaDeRealizacion;
    protected Set<Bailarin> bailarines;
    protected Bailarin profesor;

    public Clase(ClaseId claseId,
                 TipoDeClaseId tipoDeClaseId,
                 FechaProgramadaId fechaProgramadaId,
                 HoraDeInicio horaDeInicio,
                 HoraDeFinal horaDeFinal,
                 Nombre nombre,
                 Bailarin profesor){
        super(claseId);
        appendChange(new ClaseCreada(tipoDeClaseId, fechaProgramadaId, horaDeInicio, horaDeFinal, nombre, profesor)).apply();
    }

    /**
     * Cuando el Agregado esté creado
     */
    private Clase(ClaseId entityId){
        super(entityId);
        subscribe(new ClaseChange(this));
    }

    /**
     * Cuando quiero construir el Agregado (es decir que ya existe)
     * Es una factoria
     */
    public static Clase from(ClaseId claseId, List<DomainEvent> events){
        var clase = new Clase(claseId);
        events.forEach(clase::applyEvent);// como ya debe existir un suscriptor y una lista de eventos, recrea los agregados que ya estan guardados
        return clase;
    }

    public void asignarFechaDeRealizacion(FechaDeRealizacion fechaDeRealizacion){
        Objects.requireNonNull(fechaDeRealizacion);
        appendChange(new FechaDeRealizacionAsignada(fechaDeRealizacion)).apply();
    }

    public void agregarBailarin(BailarinId bailarinId, co.com.sofka.compania.bailarin.values.Nombre nombreBailarin, Telefono telefono, Email email){
        Objects.requireNonNull(bailarinId);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(telefono);
        Objects.requireNonNull(email);
        appendChange(new BailarinAgregado(bailarinId, nombreBailarin, telefono, email)).apply();
    }

    public void eliminarBailarin(BailarinId bailarinId){
        Objects.requireNonNull(bailarinId);
        appendChange(new BailarinEliminado(bailarinId)).apply();
    }

    public void cambiarTipoDeClase(TipoDeClaseId tipoDeClaseId, Nombre nombre, Descripcion descripcion){
        Objects.requireNonNull(tipoDeClaseId);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(descripcion);
        appendChange(new TipoDeClaseCambiado(tipoDeClaseId, nombre, descripcion)).apply();
    }

    public void cambiarFechaProgramada(FechaProgramadaId entityId, Fecha fecha){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(fecha);
        appendChange(new FechaProgramadaCambiada(entityId, fecha)).apply();
    }

    public void cambiarHorasDeClase(HoraDeInicio horaDeInicio, HoraDeFinal horaDeFinal){
        Objects.requireNonNull(horaDeInicio);
        Objects.requireNonNull(horaDeFinal);
        appendChange(new HorasDeClaseCambiadas(horaDeInicio, horaDeFinal)).apply();
    }

    public void actualizarNombre(Nombre nombre){
        Objects.requireNonNull(nombre);
        appendChange(new NombreActualizado(nombre)).apply();
    }

    protected Optional<Bailarin> getBailarinPorId(BailarinId bailarinId){
        return bailarines()
                .stream()
                .filter(bailarin -> bailarin.identity().equals(bailarinId))
                .findFirst();
    }

    public TipoDeClaseId tipoDeClaseId() {
        return tipoDeClaseId;
    }

    public FechaProgramadaId fechaProgramadaId() {
        return fechaProgramadaId;
    }

    public HoraDeInicio horaDeInicio() {
        return horaDeInicio;
    }

    public HoraDeFinal horaDeFinal() {
        return horaDeFinal;
    }

    public Nombre nombre() {
        return nombre;
    }

    public FechaDeRealizacion fechaDeRealizacion() {
        return fechaDeRealizacion;
    }

    public Set<Bailarin> bailarines() {
        return bailarines;
    }

    public Bailarin profesor() {
        return profesor;
    }
}
