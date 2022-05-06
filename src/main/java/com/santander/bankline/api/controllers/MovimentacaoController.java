package com.santander.bankline.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santander.bankline.api.dto.MovimentacaoDTO;
import com.santander.bankline.api.model.Movimentacao;
import com.santander.bankline.api.repositories.MovimentacaoRepository;
import com.santander.bankline.api.services.MovimentacaoService;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {

	@Autowired
	private MovimentacaoRepository repository;
	
	@Autowired
	private MovimentacaoService service;

	@GetMapping
	public List<Movimentacao> findAll() {
		return repository.findAll();
	}
	
	
	@PostMapping
	public void save(@RequestBody MovimentacaoDTO movimentacao) {
		service.save(movimentacao);
	}
}
