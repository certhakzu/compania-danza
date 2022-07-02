package co.com.example.compania.bailarin.values;

import co.com.sofka.domain.generic.Identity;

public class ExperienciaId extends Identity {

    public ExperienciaId(){

    }

    private ExperienciaId(String id){
        super(id);
    }

    public static ExperienciaId of(String id){
        return new ExperienciaId(id);
    }
}
