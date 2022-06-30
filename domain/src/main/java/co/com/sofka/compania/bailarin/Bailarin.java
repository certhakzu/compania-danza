package co.com.sofka.compania.bailarin;

import co.com.sofka.compania.bailarin.events.BailarinCreado;
import co.com.sofka.compania.bailarin.values.BailarinId;
import co.com.sofka.compania.bailarin.values.Email;
import co.com.sofka.compania.bailarin.values.Nombre;
import co.com.sofka.compania.bailarin.values.Telefono;
import co.com.sofka.domain.generic.AggregateEvent;

import java.util.List;
import java.util.Set;

public class Bailarin extends AggregateEvent<BailarinId> {

    protected Nombre nombre;
    protected Telefono telefono;
    protected Email email;
    protected Set<ClaseRealizada> claseRealizadas;
    protected List<Experiencia> experiencias;

    public Bailarin(BailarinId entityId, Nombre nombre, Telefono telefono, Email email) {
        super(entityId);
        appendChange(new BailarinCreado(nombre, telefono, email)).apply();
    }


}
