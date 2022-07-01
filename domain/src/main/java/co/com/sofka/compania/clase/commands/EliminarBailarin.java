package co.com.sofka.compania.clase.commands;

import co.com.sofka.compania.bailarin.values.BailarinId;
import co.com.sofka.domain.generic.Command;

public class EliminarBailarin extends Command {
    private final BailarinId bailarinId;


    public EliminarBailarin(BailarinId bailarinId) {
        this.bailarinId = bailarinId;
    }

    public BailarinId getBailarinId() {
        return bailarinId;
    }
}
