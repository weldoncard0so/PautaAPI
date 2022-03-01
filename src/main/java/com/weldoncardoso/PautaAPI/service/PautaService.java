package com.weldoncardoso.PautaAPI.service;

import com.weldoncardoso.PautaAPI.domain.Pauta;
import com.weldoncardoso.PautaAPI.web.rest.dto.SessaoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PautaService {
    Pauta cadastrar(Pauta toEntity);

    Pauta abrirVotacao(SessaoDTO sessaoDTO);

    Pauta buscarPorId(Long id);

    List<Pauta> consultarPautasAbertas();

    Pauta atualizarPauta(Pauta pauta);
}
