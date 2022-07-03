package co.com.example.compania.clase.values;


import co.com.sofka.domain.generic.Identity;


public class ClaseId extends Identity {

    public ClaseId(){

    }



    public ClaseId(String id){
        super(id);
    }

    public static ClaseId of(String id){
        return new ClaseId(id);
    }
}
