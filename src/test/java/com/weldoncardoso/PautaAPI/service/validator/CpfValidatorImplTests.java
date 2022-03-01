package com.weldoncardoso.PautaAPI.service.validator;

import com.weldoncardoso.PautaAPI.config.CpfConfig;
import com.weldoncardoso.PautaAPI.service.validator.impl.CpfValidadorImpl;
import com.weldoncardoso.PautaAPI.web.rest.dto.CpfDTO;
import com.weldoncardoso.PautaAPI.web.rest.exception.CpfInvalidoException;
import com.weldoncardoso.PautaAPI.builders.CpfDTOBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import static java.lang.String.format;
import static org.mockito.Mockito.mock;

public class CpfValidatorImplTests {

    @Autowired
    private CpfValidador cpfValidador;

    @Mock
    private RestTemplate restTemplate;

    private CpfConfig cpfConfig;

    String cpf;

    @BeforeEach
    public void setUp() {
        cpf = "10338927425";
        cpfConfig = new CpfConfig();
        cpfConfig.setUrl("https://user-info.herokuapp.com/users/%s");

        restTemplate = mock(RestTemplate.class);
        cpfValidador = new CpfValidadorImpl(restTemplate, cpfConfig);
    }

    @Test
    @DisplayName("deve lançar Exceção ao validar CPF Inválido")
    public void cpfDeveSerInvalido() {
        Mockito.when(this.restTemplate.getForObject(format(cpfConfig.getUrl(), cpf), CpfDTO.class)).thenReturn(CpfDTOBuilder.umCpfDTOInvalido());

        Assertions.assertThrows(CpfInvalidoException.class, ()->{
           cpfValidador.validar(cpf);
        });
    }

    @Test
    @DisplayName("cpf deve ser válido")
    public void cpfDeveSerValido() {
        Mockito.when(this.restTemplate.getForObject(format(cpfConfig.getUrl(), cpf), CpfDTO.class)).thenReturn(CpfDTOBuilder.umCpfDTOValido());
        cpfValidador.validar(cpf);
    }

}
