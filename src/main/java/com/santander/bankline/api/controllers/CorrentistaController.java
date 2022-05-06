package com.santander.bankline.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santander.bankline.api.dto.CorrentistaDTO;
import com.santander.bankline.api.model.Correntista;
import com.santander.bankline.api.repositories.CorrentistaRepository;
import com.santander.bankline.api.services.CorrentistaService;

@RestController
@RequestMapping("/correntistas")
public class CorrentistaController {

	@Autowired
	private CorrentistaRepository repository;
	
	@Autowired
	private CorrentistaService service;

	@GetMapping
	public List<Correntista> findAll() {
		return repository.findAll();
	}
	
	
	@PostMapping
	public void save(@RequestBody CorrentistaDTO correntista) {
		service.save(correntista );
	}
}
