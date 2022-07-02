package co.com.example.compania.clase.commands;

import co.com.example.compania.bailarin.values.BailarinId;
import co.com.sofka.domain.generic.Command;

public class EliminarBailarinCommand extends Command {
    private final BailarinId bailarinId;


    public EliminarBailarinCommand(BailarinId bailarinId) {
        this.bailarinId = bailarinId;
    }

    public BailarinId getBailarinId() {
        return bailarinId;
    }
}
