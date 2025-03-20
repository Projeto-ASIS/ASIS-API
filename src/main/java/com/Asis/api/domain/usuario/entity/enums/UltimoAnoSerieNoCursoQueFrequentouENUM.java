package com.Asis.api.domain.usuario.entity.enums;

public enum UltimoAnoSerieNoCursoQueFrequentouENUM {
    PRIMEIRO (1),
    SEGUNDO (2),
    TERCEIRO (3),
    QUARTO (4),
    QUINTO (5),
    SEXTO (6),
    SETIMO (7),
    OITAVO (8),
    NONO (9),
    CURSO_NAO_SERIADO (10);

    private int code;

    private UltimoAnoSerieNoCursoQueFrequentouENUM(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }

    public static UltimoAnoSerieNoCursoQueFrequentouENUM valueOf(int code) {
        for (UltimoAnoSerieNoCursoQueFrequentouENUM value : UltimoAnoSerieNoCursoQueFrequentouENUM.values()){
            if (value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid ultimoAnoSerieNoCursoQueFrequentouENUM found with code: " + code);
    }
}