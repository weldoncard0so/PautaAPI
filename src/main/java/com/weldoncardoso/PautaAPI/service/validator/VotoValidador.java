package com.weldoncardoso.PautaAPI.service.validator;

import com.weldoncardoso.PautaAPI.domain.voto.Voto;
import org.springframework.stereotype.Service;

@Service
public interface VotoValidador {
    void validar(Voto voto);
}
