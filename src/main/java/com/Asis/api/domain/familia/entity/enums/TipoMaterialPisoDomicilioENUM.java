package com.Asis.api.domain.familia.entity.enums;

public enum TipoMaterialPisoDomicilioENUM {
    TERRA(1),
    CIMENTO(2),
    MADEIRA_APROVEITADA(3),
    MADEIRA_APARELHADA(4),
    CERAMICA_LAJOTA_OU_PEDRA(5),
    CARPETE(6),
    OURO_MATERIAL(7);

    private int code;

    private TipoMaterialPisoDomicilioENUM(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static TipoMaterialPisoDomicilioENUM valueOf(int code){
        for(TipoMaterialPisoDomicilioENUM value : TipoMaterialPisoDomicilioENUM.values()){
            if(value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid TipoMaterialPisoDomicilio code: " + code);
    }
}
