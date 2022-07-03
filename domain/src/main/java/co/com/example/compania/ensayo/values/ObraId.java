package co.com.example.compania.ensayo.values;


import co.com.sofka.domain.generic.Identity;

public class ObraId extends Identity {
    public ObraId(){

    }

    public ObraId(String id){
        super(id);
    }

    public static ObraId of(String id){
        return new ObraId(id);
    }
}
