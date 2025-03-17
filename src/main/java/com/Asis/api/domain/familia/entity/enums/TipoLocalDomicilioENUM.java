package com.Asis.api.domain.familia.entity.enums;

public enum TipoLocalDomicilioENUM {
    URBANO(1),
    RURAL(2);


    private int code;

    private TipoLocalDomicilioENUM(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static TipoLocalDomicilioENUM valueOf(int code){
        for(TipoLocalDomicilioENUM value : TipoLocalDomicilioENUM.values()){
            if(value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid TipoLocalDomicilioENUM code: " + code);
    }
}
