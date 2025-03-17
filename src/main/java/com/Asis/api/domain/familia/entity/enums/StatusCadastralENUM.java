package com.Asis.api.domain.familia.entity.enums;

public enum StatusCadastralENUM {
    EM_CADASTRAMENTO(1),
    SEM_REGISTRO_CIVIL(2),
    CADASTRADO(3),
    EXCLUIDO(4);

    private int code;

    private StatusCadastralENUM(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static StatusCadastralENUM valueOf(int code){
        for(StatusCadastralENUM value : StatusCadastralENUM.values()){
            if(value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid StatusCadastralENUM code: " + code);
    } 
}
