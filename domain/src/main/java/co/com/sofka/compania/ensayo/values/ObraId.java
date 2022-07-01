package co.com.sofka.compania.ensayo.values;


import co.com.sofka.domain.generic.Identity;

public class ObraId extends Identity {
    public ObraId(){

    }

    private ObraId(String id){
        super(id);
    }

    public static ObraId of(String id){
        return new ObraId(id);
    }
}
