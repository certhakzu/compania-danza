package co.com.sofka.compania.ensayo.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;
import java.util.Objects;

public class FechaDeEstreno implements ValueObject<LocalDate> {

    private final LocalDate value;

    public FechaDeEstreno(LocalDate value) {

        if (value.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("la Fecha de Estreno no puede ser antes de hoy");
        }
        this.value = value;
    }

    @Override
    public LocalDate value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FechaDeEstreno that = (FechaDeEstreno) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
