package com.Asis.api.domain.familia.entity.enums;

public enum TipoGrupoTradicionalENUM {
    NENHUM(0),
    FAMILIA_CIGANA(2),
    FAMILIA_EXTRAVISTA(3),
    FAMILIA_DE_PESCADORES_ARTERANAIS(4),
    FAMILIA_PERTENCE_A_COMUNIDADE_DE_TERREIRO(5),
    FAMILIA_RIBEIRINHA(6),
    FAMILIA_DE_AGRICULTORES_FAMILIARES(7),
    FAMILIA_ASSENTADA_DA_REFORMA_AGRARIA(8),
    FAMILIA_BENEFICIARIA_DO_PROGRAMA_NACIONAL_DE_CREDITO_FUNDIARIO(9),
    FAMILIA_ACAMPADA(10),
    FAMILIA_ATINGIDA_POR_EMPREENDIMENTOS_DE_INFRAESTRUTURA(11),
    FAMILIA_DE_PRESO_DO_SISTEMA_CARCERARIO(12),
    FAMILIA_DE_CATADORES_DE_MATERIAL_RECICLAVEL(13);

    private int code;

    private TipoGrupoTradicionalENUM(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static TipoGrupoTradicionalENUM valueOf(int code){
        for(TipoGrupoTradicionalENUM value : TipoGrupoTradicionalENUM.values()){
            if(value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid TipoGrupoTradicional code: " + code);
    }
}
