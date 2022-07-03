package co.com.example.compania.ensayo.values;

import co.com.sofka.domain.generic.Identity;

public class FechaProgramadaId extends Identity {
    public FechaProgramadaId(){

    }

    public FechaProgramadaId(String id){
        super(id);
    }

    public static FechaProgramadaId of(String id){
        return new FechaProgramadaId(id);
    }
}
