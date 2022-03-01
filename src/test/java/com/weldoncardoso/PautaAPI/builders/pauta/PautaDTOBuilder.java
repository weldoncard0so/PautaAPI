package com.weldoncardoso.PautaAPI.builders.pauta;

import com.weldoncardoso.PautaAPI.web.rest.dto.PautaDTO;

public class PautaDTOBuilder {

    public static PautaDTO umaPautaDTO(){
        return PautaDTO.builder()
                .id(1L)
                .titulo("coxinha > all")
                .build();
    }
}
