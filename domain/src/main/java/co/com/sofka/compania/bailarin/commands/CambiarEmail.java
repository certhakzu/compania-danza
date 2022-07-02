package co.com.sofka.compania.bailarin.commands;

import co.com.sofka.compania.bailarin.values.Email;
import co.com.sofka.domain.generic.Command;

public class CambiarEmail extends Command {

    private final Email email;

    public CambiarEmail(Email email) {
        this.email = email;
    }

    public Email getEmail() {
        return email;
    }
}
