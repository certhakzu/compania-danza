package co.com.example.compania.ensayo.values;

import co.com.sofka.domain.generic.ValueObject;


import java.util.Objects;
import java.util.Set;

public class Musica implements ValueObject<Set<String>> {

    private final Set<String> value;


    public Musica(Set<String> value) {
        this.value = value;
    }

    @Override
    public Set<String> value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Musica musica = (Musica) o;
        return value.equals(musica.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
