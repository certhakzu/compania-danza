package co.com.sofka.compania.ensayo;

import co.com.sofka.compania.bailarin.Bailarin;
import co.com.sofka.compania.clase.events.BailarinEliminado;
import co.com.sofka.compania.ensayo.events.*;
import co.com.sofka.compania.ensayo.values.FechaDeRealizacion;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashSet;
import java.util.Objects;

public class EnsayoChange extends EventChange {

    public EnsayoChange(Ensayo ensayo){
        apply((EnsayoCreado event) -> {
            ensayo.fechaProgramadaId = Objects.requireNonNull(event.getFechaProgramadaId(), "fechaProgramadaId no puede ser null");
            ensayo.obraId = Objects.requireNonNull(event.getObraId(), "obraId no puede ser null");
            ensayo.bailarines = new HashSet<>();
            ensayo.horaDeInicio = Objects.requireNonNull(event.getHoraDeInicio(), "horaDeInicio no puede ser null");
            ensayo.horaDeFinal = Objects.requireNonNull(event.getHoraDeFinal(), "horaDeFinal no puede ser null");
            ensayo.descripcion = Objects.requireNonNull(event.getDescripcion(), "descripcion no puede ser null");
            ensayo.fechaDeRealizacion = new FechaDeRealizacion(value);
        });

        apply((BailarinAgregado event) -> {
            ensayo.bailarines.add(new Bailarin(
                    event.getBailarinId(),
                    event.getNombre(),
                    event.getTelefono(),
                    event.getEmail()
            ));
        });

        apply((BailarinEliminado event) -> {
            var numBailarines = ensayo.bailarines.size();
            Objects.requireNonNull(event.getBailarinId());
            if (numBailarines == 0){
                throw new IllegalArgumentException("No puede eliminar mas Bailarines de esta clase");
            }
            ensayo.bailarines.remove(ensayo.getBailarinPorId(event.getBailarinId()));
        });

        apply((DescripcionActualizada event) -> {
            ensayo.descripcion = Objects.requireNonNull(event.getDescripcion());
        });

        apply((FechaDeRealizacionAsignada event) -> {
            ensayo.fechaDeRealizacion = event.getFechaDeRealizacion();
        });

        apply((FechaProgramadaCambiada event) -> {
            ensayo.fechaProgramadaId = Objects.requireNonNull(event.getFechaProgramadaId());
        });

        apply((HorasDeEnsayoCambiadas event) -> {
            ensayo.horaDeInicio = Objects.requireNonNull(event.getHoraDeInicio());
            ensayo.horaDeFinal = Objects.requireNonNull(event.getHoraDeFinal());
        });

        apply((ObraCambiada event) -> {
            ensayo.obraId = Objects.requireNonNull(event.getObraId());
        });
    }
}
