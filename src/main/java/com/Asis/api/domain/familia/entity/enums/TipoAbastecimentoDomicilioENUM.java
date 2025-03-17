package com.Asis.api.domain.familia.entity.enums;

public enum TipoAbastecimentoDomicilioENUM {
    REDE_GERAL_DE_DISTRIBUICAO(1),
    POCO_OU_NASCENTE(2),
    CISTERNA(3),
    OUTRA_FORMA(4);

    private int code;

    private TipoAbastecimentoDomicilioENUM(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static TipoAbastecimentoDomicilioENUM valueOf(int code){
        for(TipoAbastecimentoDomicilioENUM value : TipoAbastecimentoDomicilioENUM.values()){
            if(value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid TipoAbastecimentoDomicilio code: " + code);
    }
}
