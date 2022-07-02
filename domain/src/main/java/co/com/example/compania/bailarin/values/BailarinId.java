package co.com.example.compania.bailarin.values;

import co.com.sofka.domain.generic.Identity;

public class BailarinId extends Identity {

    public BailarinId(){

    }

    private BailarinId(String id){
        super(id);
    }

    public static BailarinId of(String id){
        return new BailarinId(id);
    }
}
