package com.weldoncardoso.PautaAPI.service.impl;

import com.weldoncardoso.PautaAPI.domain.voto.Voto;
import com.weldoncardoso.PautaAPI.domain.voto.VotoPK;
import com.weldoncardoso.PautaAPI.repository.VotoRepository;
import com.weldoncardoso.PautaAPI.service.VotoService;
import com.weldoncardoso.PautaAPI.service.validator.PautaValidador;
import com.weldoncardoso.PautaAPI.service.validator.VotoValidador;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class VotoServiceImpl implements VotoService {

    private static final Logger logger = LoggerFactory.getLogger(VotoServiceImpl.class);

    private final VotoRepository votoRepository;
    private final VotoValidador votoValidador;
    private final PautaValidador pautaValidador;

    @Autowired
    public VotoServiceImpl(VotoRepository votoRepository,
                           VotoValidador votoValidador,
                           PautaValidador pautaValidador) {
        this.votoRepository = votoRepository;
        this.votoValidador = votoValidador;
        this.pautaValidador = pautaValidador;
    }

    @Override
    public Optional<Voto> buscarPorId(Voto voto){
        return votoRepository.findById(obterVotoId(voto));
    }

    @Override
    public Voto cadastrar(Voto voto) {
        votoValidador.validar(voto);
        pautaValidador.validar(voto.getIdPauta());
        logger.info("cadastrando novo voto: " + voto);
        return votoRepository.save(voto);
    }

    private VotoPK obterVotoId(Voto voto) {
        return VotoPK.builder()
                .idCooperado(1L)
                .idPauta(voto.getIdPauta())
                .build();
    }
}
