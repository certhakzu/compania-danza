package co.com.example.compania.clase.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Nombre implements ValueObject<String> {

   private final String value;

    public Nombre(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nombre nombre = (Nombre) o;
        return value.equals(nombre.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
