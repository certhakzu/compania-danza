package co.com.sofka.compania.clase.values;

import co.com.sofka.compania.bailarin.Bailarin;
import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Profesor implements ValueObject<Bailarin> {

    private final Bailarin value;

    public Profesor(Bailarin value){
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Bailarin value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profesor profesor = (Profesor) o;
        return value.equals(profesor.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
