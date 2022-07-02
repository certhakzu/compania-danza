package co.com.example.compania.bailarin.values;

import co.com.sofka.domain.generic.Identity;

public class ClaseRealizadaId extends Identity {

    public ClaseRealizadaId(){

    }

    private ClaseRealizadaId(String id){
        super(id);
    }

    public static ClaseRealizadaId of(String id){
        return new ClaseRealizadaId(id);
    }
}
