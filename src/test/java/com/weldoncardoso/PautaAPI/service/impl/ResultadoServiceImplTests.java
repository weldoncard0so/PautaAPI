package com.weldoncardoso.PautaAPI.service.impl;

import com.weldoncardoso.PautaAPI.service.PautaService;
import com.weldoncardoso.PautaAPI.service.ResultadoService;
import com.weldoncardoso.PautaAPI.web.rest.dto.ResultadoDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static com.weldoncardoso.PautaAPI.builders.pauta.PautaBuilder.*;
import static com.weldoncardoso.PautaAPI.shared.Constantes.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

public class ResultadoServiceImplTests {

    private ResultadoService resultadoService;

    private PautaService pautaService;

    @BeforeEach
    public void setUp() {
        pautaService = mock(PautaServiceImpl.class);
        resultadoService = new ResultadoServiceImpl(pautaService);
    }

    @Test
    @DisplayName("resultado da pauta deve ser Sim")
    public void resultadoDaPautaDeveSerSim() {
        Mockito.when(pautaService.buscarPorId(any(Long.class))).thenReturn(umaPautaComMaisVotosSim());

        ResultadoDTO resultadoDTO = resultadoService.obterResultado(1L);
        Assertions.assertEquals(resultadoDTO.getResultado(), SIM);
    }

    @Test
    @DisplayName("resultado da pauta deve ser Não")
    public void resultadoDaPautaDeveSerNao() {
        Mockito.when(pautaService.buscarPorId(any(Long.class))).thenReturn(umaPautaComMaisVotosNao());

        ResultadoDTO resultadoDTO = resultadoService.obterResultado(1L);
        Assertions.assertEquals(resultadoDTO.getResultado(), NAO);
    }

    @Test
    @DisplayName("resultado da pauta deve ser Empate")
    public void resultadoDaPautaDeveSerEmpate() {
        Mockito.when(pautaService.buscarPorId(any(Long.class))).thenReturn(umaPautaEmpatada());

        ResultadoDTO resultadoDTO = resultadoService.obterResultado(1L);
        Assertions.assertEquals(resultadoDTO.getResultado(), EMPATE);
    }
}
