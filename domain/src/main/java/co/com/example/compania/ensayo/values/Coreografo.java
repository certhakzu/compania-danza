package co.com.example.compania.ensayo.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Coreografo implements ValueObject<String> {

    private final String value;

    public Coreografo(String value) {

        this.value = Objects.requireNonNull(value);
        if (value.length() < 3){
            throw new IllegalArgumentException("Coreografo debe tener mimino 3 caracteres");
        }
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coreografo that = (Coreografo) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
