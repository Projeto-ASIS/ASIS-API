package com.Asis.api.domain.familia.entity.enums;

public enum TipoEspecieDomicilioENUM {
    PARTICULAR_PERMANENTE(1),
    PARTICULAR_IMPROVISADO(2),
    COLETIVO(3);

    private int code;

    private TipoEspecieDomicilioENUM(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static TipoEspecieDomicilioENUM valueOf(int code){
        for(TipoEspecieDomicilioENUM value : TipoEspecieDomicilioENUM.values()){
            if(value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid TipoEspecieDomicilioENUM code: " + code);
    }
}
