package co.com.example.compania.ensayo.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;
import java.util.Objects;

public class FechaProgramadaDeEstreno implements ValueObject<LocalDate> {

    private final LocalDate value;


    public FechaProgramadaDeEstreno(LocalDate value) {
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
        FechaProgramadaDeEstreno that = (FechaProgramadaDeEstreno) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
