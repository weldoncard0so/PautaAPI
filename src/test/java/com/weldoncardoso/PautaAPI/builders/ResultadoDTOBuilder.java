package com.weldoncardoso.PautaAPI.builders;

import com.weldoncardoso.PautaAPI.web.rest.dto.ResultadoDTO;

import static com.weldoncardoso.PautaAPI.shared.Constantes.SIM;

public class ResultadoDTOBuilder {

    public static ResultadoDTO umResultadoDTO(){
        return ResultadoDTO.builder()
                .seqPauta(1L)
                .titulo("coxinha > all")
                .quantidadeSim(100)
                .quantidadeNao(1)
                .resultado(SIM)
                .status("FECHADA")
                .build();
    }
}
