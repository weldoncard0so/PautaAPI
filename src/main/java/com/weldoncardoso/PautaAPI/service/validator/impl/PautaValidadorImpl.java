package com.weldoncardoso.PautaAPI.service.validator.impl;

import com.weldoncardoso.PautaAPI.domain.Pauta;
import com.weldoncardoso.PautaAPI.service.PautaService;
import com.weldoncardoso.PautaAPI.service.validator.PautaValidador;
import com.weldoncardoso.PautaAPI.web.rest.exception.SessaoFechadaException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.weldoncardoso.PautaAPI.shared.Constantes.SESSAO_FECHADA_EXCEPTION;

@Component
public class PautaValidadorImpl implements PautaValidador {


    private static final Logger logger = LoggerFactory.getLogger(PautaValidadorImpl.class);

    private final PautaService pautaService;

    @Autowired
    public PautaValidadorImpl(PautaService pautaService) {
        this.pautaService = pautaService;
    }

    @Override
    public void validar(Long idPauta) {
        logger.info("validando pauta nº: "+ idPauta);
        Pauta pauta = pautaService.buscarPorId(idPauta);
        if (pauta.estahFechada()) {
            throw new SessaoFechadaException(SESSAO_FECHADA_EXCEPTION);
        }
    }

}
