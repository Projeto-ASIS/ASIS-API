package com.Asis.api.domain.familia.entity.enums;

public enum FormaEscoamentoDomicilioENUM {

    REDE_COLETORA_DE_ESGOTO_OU_PLUVIAL(1),
    FOSSA_SEPTICA(2),
    FOSSA_RUDIMENTAR(3),
    VALA_A_CEU_ABERTO(4),
    DIRETO_PARA_RIO_LAGO_OU_MAR(5),
    OUTRA_FORMA(6);

    private int code;

    private FormaEscoamentoDomicilioENUM(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static FormaEscoamentoDomicilioENUM valueOf(int code){
        for(FormaEscoamentoDomicilioENUM value : FormaEscoamentoDomicilioENUM.values()){
            if(value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid FormaEscoamentoDomicilio code: " + code);
    }
}
