package co.com.sofka.compania.clase;

import co.com.sofka.compania.bailarin.Bailarin;
import co.com.sofka.compania.clase.events.*;
import co.com.sofka.compania.clase.values.FechaDeRealizacion;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashSet;
import java.util.Objects;

public class ClaseChange extends EventChange {
    public ClaseChange(Clase clase){
        apply((ClaseCreada event) -> {
            clase.tipoDeClaseId = Objects.requireNonNull(event.getTipoDeClaseId(), "No puede ser null tipoDeClaseID");
            clase.fechaProgramadaId = Objects.requireNonNull(event.getFechaProgramadaId(), "No puede ser null fechaProgramadaId");
            clase.horaDeInicio = Objects.requireNonNull(event.getHoraDeInicio(), "No puede ser null la horaDeInicio");
            clase.horaDeFinal = Objects.requireNonNull(event.getHoraDeFinal(), "No puede ser null la horaDeFinal");
            clase.nombre = Objects.requireNonNull(event.getNombre(), "No puede ser null el nombre");
            clase.profesor = Objects.requireNonNull(event.getProfesor(), "No puede ser null el profesor");
            clase.fechaDeRealizacion = new FechaDeRealizacion();
            clase.bailarines = new HashSet<>();
        });

        apply((BailarinAgregado event) -> {
            clase.bailarines.add(new Bailarin(
                    event.getBailarinId(),
                    event.getNombre(),
                    event.getTelefono(),
                    event.getEmail()
            ));
        });

        apply((BailarinEliminado event) -> {
            var numBailarines = clase.bailarines.size();
            if (numBailarines == 0){
                throw new IllegalArgumentException("No puede eliminar mas Bailarines de esta clase");
            }
            clase.bailarines.remove(clase.getBailarinPorId(event.getBailarinId()));
        });

        apply((FechaDeRealizacionAsignada event) -> {
            clase.fechaDeRealizacion = event.getFechaDeRealizacion();
        });

        apply((FechaProgramadaCambiada event) -> {
            clase.fechaProgramadaId = event.getFechaProgramadaId();
        });

        apply((HorasDeClaseCambiadas event) -> {
            clase.horaDeInicio = event.getHoraDeInicio();
            clase.horaDeFinal = event.getHoraDeFinal();
        });

        apply((NombreActualizado event) -> {
            clase.nombre = event.getNombre();
        });

        apply((TipoDeClaseCambiado event) -> {
            clase.tipoDeClaseId = event.getTipoDeClaseId();
        });
    }
}
