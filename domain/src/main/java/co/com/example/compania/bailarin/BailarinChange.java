package co.com.example.compania.bailarin;

import co.com.example.compania.bailarin.events.*;
import co.com.sofka.domain.generic.EventChange;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BailarinChange extends EventChange {
    public BailarinChange(Bailarin bailarin) {

        apply((BailarinCreado event) -> {
            bailarin.nombre = Objects.requireNonNull(event.getNombre(), "No puede ser null");
            bailarin.email = Objects.requireNonNull(event.getEmail(), "No puede ser null");
            bailarin.telefono = Objects.requireNonNull(event.getTelefono(), "No puede ser null");
            bailarin.experiencias = new ArrayList<>();
            bailarin.claseRealizadas = new HashSet<>();
        });


        apply((EmailCambiado event) -> {
            String regx = "^(.+)@(.+)$";
            Pattern pattern = Pattern.compile(regx);
            Matcher matcher = pattern.matcher(event.getEmail().value());
            if (matcher.matches()){
                bailarin.email = event.getEmail();
            } else {
                throw new IllegalArgumentException("El Email no tiene la estructura correcta");
            }
        });

        apply((NombreCambiado event) -> {
            if (event.getNombre().value().isBlank()){
                throw new IllegalArgumentException("Nombre no aceptado");
            } else {
                bailarin.nombre = event.getNombre();
            }
        });

        apply((TelefonoCambiado event) -> {
            if (event.getTelefono().value().isBlank()){
                throw new IllegalArgumentException("Telefono no aceptado");
            } else {
                bailarin.telefono = event.getTelefono();
            }
        });

        apply((ExperienciaAgregada event) -> {
            bailarin.experiencias.add(new Experiencia(
                    event.getExperienciaId(),
                    event.getEstilo(),
                    event.getLugar(),
                    event.getDuracion()
            ));
        });

        apply((ExperienciaEliminada event) -> {
            var numExperiencias = bailarin.experiencias().size();
            if (numExperiencias == 0){
                throw new IllegalArgumentException("No puedes eliminar mas experiencias");
            } else {
                for (int i = bailarin.experiencias.size(); i > -1; i--){
                    if (bailarin.experiencias.get(i).identity().equals(event.getExperienciaId())){
                        bailarin.experiencias.remove(i);
                        break;
                    }
                }
            }
        });

        apply((ClaseRealizadaAgregada event) -> {
            bailarin.claseRealizadas.add(new ClaseRealizada(
                    event.getClaseRealizadaId(),
                    event.getClaseId(),
                    event.getFechaDeRealizacion()
            ));
        });

        apply((ClaseRealizadaEliminada event) -> {
            var numClasesRealizadas = bailarin.claseRealizadas().size();
            if (numClasesRealizadas == 0){
                throw new IllegalArgumentException("No puedes eliminar mas Clases Realizadas");
            } else {
                bailarin.claseRealizadas.remove(bailarin.getClaseRealizadaPorId(event.getClaseRealizadaId()));
            }
        });
    }
}
