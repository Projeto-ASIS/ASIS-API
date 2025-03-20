package com.Asis.api.domain.usuario.entity.enums;

public enum CursoMaisElevadoQueFrequentouENUM {

    CRECHE (1),
    PRE_ESCOLA_EXCETO_CA (2),
    CLASSE_DE_ALFABETIZACAO_CA (3),
    ENSINO_FUNDAMENTAL_1A_A_4A_SERIES_ELEMENTAR_PRIMARIO_PRIMEIRA_FASE_DO_1O_GRAU (4),
    ENSINO_FUNDAMENTAL_5A_A_8A_SERIES_MEDIO_1O_CICLO_GINASIAL_SEGUNDA_FASE_DO_1O_GRAU (5),
    ENSINO_FUNDAMENTAL (6),
    ENSINO_FUNDAMENTAL_ESPECIAL (7),
    ENSINO_MEDIO_2O_GRAU_MEDIO_2O_CICLO_CIENTIFICO_CLASSICO_TECNICO_NORMAL (8),
    ENSINO_MEDIO_ESPECIAL (9),
    ENSINO_FUNDAMENTAL_EJA_SERIES_INICIAIS (10),
    ENSINO_FUNDAMENTAL_EJA_SERIES_FINAIS_SUPLETIVO(11),
    ENSINO_MEDIO_EJA (12),
    SUPERIOR_APERFEICOAMENTO_ESPECIALIZACAO_MESTRADO_DOUTORADO (13),
    ALFABETIZACAO_PARA_ADULTOS (14),
    NENHUM (15);

    private int code;

    private CursoMaisElevadoQueFrequentouENUM(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }

    public static CursoMaisElevadoQueFrequentouENUM valueOf(int code) {
        for (CursoMaisElevadoQueFrequentouENUM value : CursoMaisElevadoQueFrequentouENUM.values()){
            if (value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid cursoMaisElevadoQueFrequentouENUM found with code: " + code);
    }
}