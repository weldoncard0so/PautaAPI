package com.weldoncardoso.PautaAPI.builders;

import com.weldoncardoso.PautaAPI.web.rest.dto.CpfDTO;

import static com.weldoncardoso.PautaAPI.shared.Constantes.ABLE_TO_VOTE;
import static com.weldoncardoso.PautaAPI.shared.Constantes.UNABLE_TO_VOTE;

public class CpfDTOBuilder {

    public static CpfDTO umCpfDTOInvalido(){
        return CpfDTO.builder()
                .status(UNABLE_TO_VOTE)
                .build();
    }

    public static CpfDTO umCpfDTOValido(){
        return CpfDTO.builder()
                .status(ABLE_TO_VOTE)
                .build();
    }
}
