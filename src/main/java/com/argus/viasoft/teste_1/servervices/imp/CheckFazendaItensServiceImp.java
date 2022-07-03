package com.argus.viasoft.teste_1.servervices.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.argus.viasoft.teste_1.enums.FazendaAutorizador;
import com.argus.viasoft.teste_1.models.CheckFazenda;
import com.argus.viasoft.teste_1.models.CheckFazendaItens;
import com.argus.viasoft.teste_1.ropositories.CheckFazendaItensRepository;
import com.argus.viasoft.teste_1.servervices.CheckFazendaItensService;
import com.argus.viasoft.teste_1.utils.CountResult;

@Service
public class CheckFazendaItensServiceImp implements CheckFazendaItensService {

	@Autowired
	private CheckFazendaItensRepository checkFazendaItensRepository;
	
	@Override
	public List<CheckFazendaItens> loadByCheckFazenda(CheckFazenda check) {
		return checkFazendaItensRepository.findByPkCheckFazenda(check);
	}

	@Override
	public List<CheckFazendaItens> loadByCheckFazendaAutorizador(CheckFazenda check,
			List<FazendaAutorizador> autorizadores) {
		 List<CheckFazendaItens> itens = checkFazendaItensRepository.findByPkCheckFazenda(check);
		 
		 return itens.stream().filter(i -> autorizadores.contains(i.getPk().getAutorizador())).collect(Collectors.toList());
	}

	@Override
	public CountResult<List<FazendaAutorizador>> findMostInstableAutorizador() {
		List<FazendaAutorizador> auts = new ArrayList<>();
		var i = 0L;
		for (FazendaAutorizador aut : FazendaAutorizador.values()) {
			long t = checkFazendaItensRepository.countByPkAutorizadorFail(aut);
			
			if (t == i)
				auts.add(aut);
			
			if (t > i) {
				auts = new ArrayList<>();
				auts.add(aut);
				i = t;
			}
			
			
		}
		return new CountResult<>(auts, i);
	}
	
}
