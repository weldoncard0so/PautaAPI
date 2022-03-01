package com.weldoncardoso.PautaAPI.web.rest;

import com.weldoncardoso.PautaAPI.domain.Pauta;
import com.weldoncardoso.PautaAPI.service.PautaService;
import com.weldoncardoso.PautaAPI.web.rest.dto.PautaDTO;
import com.weldoncardoso.PautaAPI.web.rest.dto.SessaoDTO;
import com.weldoncardoso.PautaAPI.web.rest.mapper.PautaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pautas")
public class PautaResource {

    private final PautaService pautaService;

    @Autowired
    public PautaResource(PautaService pautaService) {
        this.pautaService = pautaService;
    }

    @PostMapping(headers = "Api-Version=1")
    public ResponseEntity<Object> cadastrar(@RequestBody PautaDTO pautaDTO) {
        Pauta pautaCadastrada = pautaService.cadastrar(PautaMapper.toEntity(pautaDTO));
        return new ResponseEntity<>(PautaMapper.toDto(pautaCadastrada), HttpStatus.CREATED);
    }

    @PostMapping(value = "/abrir", headers = "Api-Version=1")
    public ResponseEntity<Object> abrirVotacao(@RequestBody SessaoDTO sessaoDTO) {
        Pauta pautaAberta = pautaService.abrirVotacao(sessaoDTO);
        return new ResponseEntity<>(PautaMapper.toDto(pautaAberta), HttpStatus.ACCEPTED);
    }
}