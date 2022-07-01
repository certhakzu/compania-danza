package co.com.sofka.compania.clase.values;


import co.com.sofka.domain.generic.Identity;


public class ClaseId extends Identity {

    public ClaseId(){

    }

    private ClaseId(String id){
        super(id);
    }

    public static ClaseId of(String id){
        return new ClaseId(id);
    }
}
