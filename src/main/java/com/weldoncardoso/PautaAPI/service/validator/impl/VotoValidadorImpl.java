package com.weldoncardoso.PautaAPI.service.validator.impl;

import com.weldoncardoso.PautaAPI.domain.voto.Voto;
import com.weldoncardoso.PautaAPI.domain.voto.VotoPK;
import com.weldoncardoso.PautaAPI.repository.VotoRepository;
import com.weldoncardoso.PautaAPI.service.validator.CpfValidador;
import com.weldoncardoso.PautaAPI.service.validator.VotoValidador;
import com.weldoncardoso.PautaAPI.web.rest.exception.VotoDuplicadoException;
import com.weldoncardoso.PautaAPI.web.rest.exception.VotoInvalidoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.weldoncardoso.PautaAPI.shared.Constantes.*;

@Component
public class VotoValidadorImpl implements VotoValidador {

    private static final Logger logger = LoggerFactory.getLogger(VotoValidadorImpl.class);

    private final VotoRepository votoRepository;
    private final CpfValidador cpfValidador;

    @Autowired
    public VotoValidadorImpl(VotoRepository votoRepository,
                             CpfValidador cpfValidador) {
        this.votoRepository = votoRepository;
        this.cpfValidador = cpfValidador;
    }

    @Override
    public void validar(Voto voto) {
        logger.info("validando voto: " + voto);
        Optional<Voto> votoConsultado = votoRepository.findById(obterVotoId(voto));
        validar(voto.getVoto());
        if (votoConsultado.isPresent()) {
            throw new VotoDuplicadoException(VOTO_DUPLICADO_EXCEPTION);
        }
        cpfValidador.validar(voto.getCpf());
    }

    private void validar(String voto) {
        if(!(voto.equals(SIM) || voto.equals(NAO))){
            throw new VotoInvalidoException(VOTO_INVALIDO_EXCEPTION);
        }
    }

    private VotoPK obterVotoId(Voto voto) {
        return VotoPK.builder()
                .idCooperado(voto.getIdCooperado())
                .idPauta(voto.getIdPauta())
                .build();
    }


}
