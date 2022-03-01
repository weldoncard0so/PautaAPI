package com.weldoncardoso.PautaAPI.service;

import com.weldoncardoso.PautaAPI.web.rest.dto.ResultadoDTO;
import org.springframework.stereotype.Service;

@Service
public interface ResultadoService {
    ResultadoDTO obterResultado(Long id);
}
