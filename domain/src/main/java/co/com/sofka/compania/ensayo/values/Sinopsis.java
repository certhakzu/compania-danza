package co.com.sofka.compania.ensayo.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Sinopsis implements ValueObject<String> {

    private final String value;

    public Sinopsis(String value) {
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
        Sinopsis sinopsis = (Sinopsis) o;
        return value.equals(sinopsis.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
