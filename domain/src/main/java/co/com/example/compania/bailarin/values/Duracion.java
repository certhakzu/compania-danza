package co.com.example.compania.bailarin.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Duracion implements ValueObject<Float> {

    private final Float value;

    public Duracion(Float value) {
        this.value = Objects.requireNonNull(value);
        if (value.isNaN() || value < 0.0){
            throw new IllegalArgumentException("La Duracion debe ser un Float");
        }
    }

    public Duracion cambiarDuracion(Float value){
        return new Duracion(value);
    }

    @Override
    public Float value() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Duracion that = (Duracion) obj;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
