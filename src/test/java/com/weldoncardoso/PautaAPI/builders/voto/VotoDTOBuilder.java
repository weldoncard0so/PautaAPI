package com.weldoncardoso.PautaAPI.builders.voto;

import com.weldoncardoso.PautaAPI.web.rest.dto.VotoDTO;

import static com.weldoncardoso.PautaAPI.shared.Constantes.SIM;

public class VotoDTOBuilder {

    public static VotoDTO umVotoDTO() {
        return VotoDTO.builder()
                .cpf("10338927425")
                .idCooperado(1L)
                .idPauta(1L)
                .voto(SIM)
                .build();
    }

    public static VotoDTO umVotoDTO(String voto) {
        return VotoDTO.builder()
                .cpf("10338927425")
                .idCooperado(1L)
                .idPauta(1L)
                .voto(voto)
                .build();
    }
}
