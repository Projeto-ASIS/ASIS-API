package com.Asis.api.domain.familia.entity.enums;

public enum TipoDestinoLixoDomicilioENUM {
    COLETADO_DIRETAMENTE(1),
    COLETADO_INDIRETAMENTE(2),
    QUEIMADO_OU_ENTERRADO_NA_PROPRIEDADE(3),
    JOGADO_EM_TERRENO_BADIO_OU_LOGRADOURO(4),
    JOGADO_EM_RIO_OU_MAR(5),
    OUTRO_DESTINO(6);

    private int code;

    private TipoDestinoLixoDomicilioENUM(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static TipoDestinoLixoDomicilioENUM valueOf(int code){
        for(TipoDestinoLixoDomicilioENUM value : TipoDestinoLixoDomicilioENUM.values()){
            if(value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid TipoDestinoLixoDomicilio code: " + code);
    }
}
