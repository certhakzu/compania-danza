package co.com.sofka.compania.ensayo.events;

import co.com.sofka.compania.ensayo.values.Musica;
import co.com.sofka.domain.generic.DomainEvent;

public class MusicaDeObraActualizada extends DomainEvent {

    private Musica musica;

    public MusicaDeObraActualizada(Musica musica){
        super("co.com.sofka.compania.ensayo.musicadeobraactualizada");
        this.musica = musica;
    }
}
