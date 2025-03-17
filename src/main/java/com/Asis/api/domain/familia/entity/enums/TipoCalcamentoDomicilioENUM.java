package com.Asis.api.domain.familia.entity.enums;

public enum TipoCalcamentoDomicilioENUM {
    TOTAL(1),
    PARCIAL(2),
    NAO_EXISTE(3);

    private int code;

    private TipoCalcamentoDomicilioENUM(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static TipoCalcamentoDomicilioENUM valueOf(int code){
        for(TipoCalcamentoDomicilioENUM value : TipoCalcamentoDomicilioENUM.values()){
            if(value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid TipoCalcamentoDomicilio code: " + code);
    }
}
