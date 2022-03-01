package com.weldoncardoso.PautaAPI.service.validator;

import com.weldoncardoso.PautaAPI.service.PautaService;
import com.weldoncardoso.PautaAPI.service.impl.PautaServiceImpl;
import com.weldoncardoso.PautaAPI.service.validator.impl.PautaValidadorImpl;
import com.weldoncardoso.PautaAPI.web.rest.exception.SessaoFechadaException;
import com.weldoncardoso.PautaAPI.builders.pauta.PautaBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

public class PautaValidatorImplTests {

    @Autowired
    private PautaValidador pautaValidador;

    @MockBean
    private PautaService pautaService;

    @BeforeEach
    public void setUp() {
        pautaService = mock(PautaServiceImpl.class);
        pautaValidador = new PautaValidadorImpl(pautaService);
    }

    @Test
    @DisplayName("não deve lançar exceção ao validar pauta aberta")
    public void naoDeveLancarExcecaoAoValidarPautaAberta() {
        Mockito.when(pautaService.buscarPorId(any(Long.class))).thenReturn(PautaBuilder.umaPautaAberta());

        pautaValidador.validar(1L);
    }

    @Test
    @DisplayName("deve lançar uma excecao ao validar pauta fechada")
    public void deveLancarUmaExcecaoAoValidarPautaFechada(){
        Mockito.when(pautaService.buscarPorId(any(Long.class))).thenReturn(PautaBuilder.umaPautaFechada());

        Assertions.assertThrows(SessaoFechadaException.class, ()->{
           pautaValidador.validar(1L);
        });
    }
}
