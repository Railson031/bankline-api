package com.santander.bankline.api.services;

import java.time.LocalDateTime;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santander.bankline.api.dto.MovimentacaoDTO;
import com.santander.bankline.api.model.Correntista;
import com.santander.bankline.api.model.Movimentacao;
import com.santander.bankline.api.model.MovimentacaoTipo;
import com.santander.bankline.api.repositories.CorrentistaRepository;
import com.santander.bankline.api.repositories.MovimentacaoRepository;


@Service
public class MovimentacaoService {
	
	
	
	
	@Autowired
	private CorrentistaRepository correntistaRepository;
	

	@Autowired
	private MovimentacaoRepository repository;
	
	public void save(MovimentacaoDTO movimentacaoDTO) {
		Movimentacao movimentacao = new Movimentacao();
		
		Double valor = movimentacaoDTO.getValor();
		if(movimentacaoDTO.getTipo() == MovimentacaoTipo.DESPESA) {
			valor = valor * -1;
		}
		
		movimentacao.setDataHora(LocalDateTime.now());
		movimentacao.setDescricao(movimentacaoDTO.getDescricao());
		movimentacao.setIdConta(movimentacaoDTO.getIdConta());
		movimentacao.setTipo(movimentacaoDTO.getTipo());
		movimentacao.setValor(valor);
		
		
		Correntista correntista = correntistaRepository.findById(movimentacaoDTO.getIdConta()).orElse(null);
		
		if(correntista != null) {
			correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor);
			correntistaRepository.save(correntista);
			
		}
	
		repository.save(movimentacao);
		
	}

}
