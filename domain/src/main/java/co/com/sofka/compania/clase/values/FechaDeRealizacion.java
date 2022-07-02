package co.com.sofka.compania.clase.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;


import java.util.Objects;

public class FechaDeRealizacion implements ValueObject<LocalDate> {
    private final LocalDate value;

    public FechaDeRealizacion() {
        this.value = LocalDate.now();
    }

    public FechaDeRealizacion(LocalDate value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public LocalDate value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FechaDeRealizacion that = (FechaDeRealizacion) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
