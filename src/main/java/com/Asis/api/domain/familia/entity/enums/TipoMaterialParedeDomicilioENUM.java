package com.Asis.api.domain.familia.entity.enums;

public enum TipoMaterialParedeDomicilioENUM {

    ALVENARIA_TIJOLO_REVESTIDO(1),
    ALVENARIA_TIJOLO_NAO_REVESTIDO(2),
    MADEIRA_APARELHADA(3),
    TAIPA_REVESTIDA(4),
    TAIPA_NAO_REVESTIDA(5),
    MADEIRA_APROVEITADA(6),
    PALHA(7),
    OUTRO_MATERIAL(8);

    private int code;

    private TipoMaterialParedeDomicilioENUM(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static TipoMaterialParedeDomicilioENUM valueOf(int code){
        for(TipoMaterialParedeDomicilioENUM value : TipoMaterialParedeDomicilioENUM.values()){
            if(value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid TipoMaterialParedeDomicilio code: " + code);
    }

}
