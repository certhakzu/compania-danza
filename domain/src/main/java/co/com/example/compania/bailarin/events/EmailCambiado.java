package co.com.example.compania.bailarin.events;

import co.com.example.compania.bailarin.values.Email;
import co.com.sofka.domain.generic.DomainEvent;

public class EmailCambiado extends DomainEvent {

    private final Email email;

    public EmailCambiado(Email email) {
        super("co.com.sofka.compania.bailarin.emailcambiado");
        this.email = email;
    }

    public Email getEmail() {
        return email;
    }
}
