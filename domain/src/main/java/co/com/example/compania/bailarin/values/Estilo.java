package co.com.example.compania.bailarin.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Estilo implements ValueObject<String> {

    private final String value;

    public Estilo(String value) {

        this.value = Objects.requireNonNull(value);
        if (value.isBlank()){
            throw new IllegalArgumentException("Estilo no puede venir en Blanco");
        }
    }

    public Estilo cambiarEstilo(String value){
        return new Estilo(value);
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Estilo that = (Estilo) obj;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
