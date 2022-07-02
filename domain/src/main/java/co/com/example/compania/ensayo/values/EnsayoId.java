package co.com.example.compania.ensayo.values;

import co.com.sofka.domain.generic.Identity;

public class EnsayoId extends Identity {
    public EnsayoId(){

    }

    private EnsayoId(String id){
        super(id);
    }

    public static EnsayoId of(String id){
        return new EnsayoId(id);
    }
}
