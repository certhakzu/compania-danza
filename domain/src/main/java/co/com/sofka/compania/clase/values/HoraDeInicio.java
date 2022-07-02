package co.com.sofka.compania.clase.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDateTime;
import java.util.Objects;

public class HoraDeInicio implements ValueObject<LocalDateTime> {
    private final LocalDateTime value;

    public HoraDeInicio(LocalDateTime value) {
        this.value = value;
    }

    @Override
    public LocalDateTime value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HoraDeInicio that = (HoraDeInicio) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
