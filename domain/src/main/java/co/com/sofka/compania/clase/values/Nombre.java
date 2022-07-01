package co.com.sofka.compania.clase.values;

import co.com.sofka.domain.generic.Identity;

public class Nombre extends Identity {

    public Nombre(){

    }

    private Nombre(String id){
        super(id);
    }

    public static Nombre of(String id){
        return new Nombre(id);
    }
}
