package com.Asis.api.domain.usuario.entity.enums;

public enum TipoRelacaoParentescoRFENUM {

    PESSOA_RESPONSAVEL_PELA_UNIDADE_FAMILIAR_RF (1),
    CONJUGE_OU_COMPANHEIROA (2),
    FILHO_A (3),
    ENTEADO_A (4),
    NETOA_OU_BISNETO_A (5),
    PAI_OU_MAE (6),
    SOGROA (7),
    IRMAO_OU_IRMA (8),
    GENRO_OU_NORA (9),
    OUTRO_PARENTE (10),
    NAO_PARENTE (11);

    private int code;

    private TipoRelacaoParentescoRFENUM(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }

    public static TipoRelacaoParentescoRFENUM valueOf(int code) {
        for (TipoRelacaoParentescoRFENUM value : TipoRelacaoParentescoRFENUM.values()){
            if (value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid tipoRelacaoParentescoRFENUM found with code: " + code);
    }
}