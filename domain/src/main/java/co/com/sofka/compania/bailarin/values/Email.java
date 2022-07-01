package co.com.sofka.compania.bailarin.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Email implements ValueObject {

    private final String value;

    public Email(String value) {

        this.value = Objects.requireNonNull(value);
        if (value.isBlank()){
            throw new IllegalArgumentException("Email no puede venir en Blanco");
        }
        if (!value.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")){
            throw new IllegalArgumentException("El Email no es valido");
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
        Email email = (Email) o;
        return value.equals(email.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
