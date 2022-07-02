package co.com.example.compania.ensayo.events;

import co.com.example.compania.bailarin.values.BailarinId;
import co.com.sofka.domain.generic.DomainEvent;

public class BailarinEliminado extends DomainEvent {

    private BailarinId bailarinId;

    public BailarinEliminado(BailarinId bailarinId){
        super("co.com.sofka.compania.clase.bailarineliminado");
        this.bailarinId = bailarinId;
    }

    public BailarinId getBailarinId() {
        return bailarinId;
    }
}
