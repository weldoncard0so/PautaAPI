package com.weldoncardoso.PautaAPI.service.validator;

import com.weldoncardoso.PautaAPI.domain.voto.VotoPK;
import com.weldoncardoso.PautaAPI.repository.VotoRepository;
import com.weldoncardoso.PautaAPI.service.validator.impl.VotoValidadorImpl;
import com.weldoncardoso.PautaAPI.web.rest.exception.VotoDuplicadoException;
import com.weldoncardoso.PautaAPI.web.rest.exception.VotoInvalidoException;
import com.weldoncardoso.PautaAPI.builders.voto.VotoBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static com.weldoncardoso.PautaAPI.builders.voto.VotoBuilder.umVoto;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

public class VotoValidadorImplTests {

    @Autowired
    private VotoValidador votoValidador;

    @MockBean
    private CpfValidador cpfValidador;

    @MockBean
    private VotoRepository votoRepository;

    @BeforeEach
    public void setUp() {
        cpfValidador = mock(CpfValidador.class);
        votoRepository = mock(VotoRepository.class);
        this.votoValidador = new VotoValidadorImpl(votoRepository, cpfValidador);
    }

    @Test
    @DisplayName("não deve lançar exceção ao validar CPF")
    public void naoDeveLancarExcecaoAoValidar(){
        Mockito.when(this.votoRepository.findById(any(VotoPK.class))).thenReturn(Optional.empty());

        votoValidador.validar(VotoBuilder.umVoto());
    }

    @Test
    @DisplayName("deve lançar exceção ao validar voto duplicado")
    public void deveLancarExcecaoAoValidarVotoDuplicado(){
        Mockito.when(this.votoRepository.findById(any(VotoPK.class))).thenReturn(Optional.of(VotoBuilder.umVoto()));

        Assertions.assertThrows(VotoDuplicadoException.class, ()->{
            votoValidador.validar(VotoBuilder.umVoto());
        });
    }

    @Test
    @DisplayName("não deve lançar exceção ao validar voto Sim válido")
    public void naoDeveLancarExcecaoAoValidarVotoSimValido(){
        Mockito.when(this.votoRepository.findById(any(VotoPK.class))).thenReturn(Optional.empty());

        votoValidador.validar(VotoBuilder.umVoto("Sim"));
    }

    @Test
    @DisplayName("deve lançar exceção ao validar voto Sim inváldio")
    public void deveLancarExcecaoAoValidarVotoSimInvalido(){
        Mockito.when(this.votoRepository.findById(any(VotoPK.class))).thenReturn(Optional.empty());

        Assertions.assertThrows(VotoInvalidoException.class, ()->{
            votoValidador.validar(VotoBuilder.umVoto("sim"));
        });
    }

    @Test
    @DisplayName("não deve lançar exceção ao validar voto Não válido")
    public void naoDeveLancarExcecaoAoValidarVotoNaoValido(){
        Mockito.when(this.votoRepository.findById(any(VotoPK.class))).thenReturn(Optional.empty());

        votoValidador.validar(VotoBuilder.umVoto("Não"));
    }


    @Test
    @DisplayName("deve lançar exceção ao validar voto inváldio")
    public void deveLancarExcecaoAoValidarVotoInvalido(){
        Mockito.when(this.votoRepository.findById(any(VotoPK.class))).thenReturn(Optional.empty());

        Assertions.assertThrows(VotoInvalidoException.class, ()->{
            votoValidador.validar(VotoBuilder.umVoto("sim"));
        });
    }



}
