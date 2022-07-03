package co.com.example.compania.bailarin.commands;

import co.com.example.compania.bailarin.values.BailarinId;
import co.com.example.compania.bailarin.values.Email;
import co.com.sofka.domain.generic.Command;

public class CambiarEmailCommand extends Command {

    private final BailarinId bailarinId;
    private final Email email;

    public CambiarEmailCommand(BailarinId bailarinId, Email email) {
        this.bailarinId = bailarinId;
        this.email = email;
    }

    public Email getEmail() {
        return email;
    }

    public BailarinId getBailarinId() {
        return bailarinId;
    }
}
