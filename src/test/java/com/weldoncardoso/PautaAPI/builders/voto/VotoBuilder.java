package com.weldoncardoso.PautaAPI.builders.voto;

import com.weldoncardoso.PautaAPI.domain.voto.Voto;

import static com.weldoncardoso.PautaAPI.shared.Constantes.SIM;

public class VotoBuilder {

    public static Voto umVoto() {
        return Voto.builder()
                .cpf("10338927425")
                .idPauta(1L)
                .voto(SIM)
                .build();
    }

    public static Voto umVoto(String voto) {
        return Voto.builder()
                .cpf("10338927425")
                .idPauta(1L)
                .voto(voto)
                .build();
    }
}
