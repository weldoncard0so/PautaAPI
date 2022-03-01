package com.weldoncardoso.PautaAPI.service.validator;

import org.springframework.stereotype.Service;

@Service
public interface PautaValidador {
    void validar(Long idPauta);
}
