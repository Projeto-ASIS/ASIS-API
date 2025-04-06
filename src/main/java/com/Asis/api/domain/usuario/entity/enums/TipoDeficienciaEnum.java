package com.Asis.api.domain.usuario.entity.enums;

public enum TipoDeficienciaEnum {
    FISICA(1),
    VISUAL(2),
    INTELECTUAL(3),
    AUDITIVA(4);

    private int code;
    
    

    TipoDeficienciaEnum(int i) {
        this.code = i;
    }
    
    int getCode(){
        return this.code;
    }

    public static TipoDeficienciaEnum valueOf(int code){
        for(TipoDeficienciaEnum value: TipoDeficienciaEnum.values()){
            if(value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Código inválido: " + code);
    }
    
}
