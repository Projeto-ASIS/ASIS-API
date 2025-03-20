package com.Asis.api.domain.usuario.entity.enums;

public enum CorRacaENUM {
    BRANCA(1),
    PRETA(2),
    AMARELA(3),
    PARDA(4),
    INDIGENA(5);

    private int code;

    private CorRacaENUM(int code) {
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
        throw new IllegalArgumentException("Invalid CorRacaENUM found with code: " + code);
    }
}
