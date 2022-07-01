package co.com.sofka.compania.ensayo.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Duracion implements ValueObject<Float> {

    private final Float value;


    public Duracion(Float value) {
        this.value = Objects.requireNonNull(value);
        if (this.value < 0.0){
            throw new IllegalArgumentException("duracion debe ser minimo 0.0");
        }
    }

    @Override
    public Float value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Duracion duracion = (Duracion) o;
        return value.equals(duracion.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
