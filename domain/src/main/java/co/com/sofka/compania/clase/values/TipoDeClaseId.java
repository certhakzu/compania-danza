package co.com.sofka.compania.clase.values;

import co.com.sofka.compania.bailarin.values.ClaseRealizadaId;
import co.com.sofka.domain.generic.Identity;

public class TipoDeClaseId extends Identity {

    public TipoDeClaseId(){

    }

    private TipoDeClaseId(String id){
        super(id);
    }

    public static TipoDeClaseId of(String id){
        return new TipoDeClaseId(id);
    }
}
