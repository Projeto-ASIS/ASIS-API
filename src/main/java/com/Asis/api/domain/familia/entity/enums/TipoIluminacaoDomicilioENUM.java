package com.Asis.api.domain.familia.entity.enums;

public enum TipoIluminacaoDomicilioENUM {
    ELETRICA_COM_MEDIDOR_PROPRIO(1),
    ELETRICA_COM_MEDIDOR_COMUNITARIO(2),
    ELETRICA_SEM_MEDIDOR(3),
    OLEO_QUEROSENE_OU_GAS(4),
    VELA(5),
    OUTRA_FORMA(6);

    private int code;

    private TipoIluminacaoDomicilioENUM(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static TipoIluminacaoDomicilioENUM valueOf(int code){
        for(TipoIluminacaoDomicilioENUM value : TipoIluminacaoDomicilioENUM.values()){
            if(value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid TipoIluminacaoDomicilio code: " + code);
    }
}
