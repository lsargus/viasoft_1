package com.argus.viasoft.teste_1.servervices.imp;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.argus.viasoft.teste_1.models.CheckFazenda;
import com.argus.viasoft.teste_1.ropositories.CheckFazendaRepository;
import com.argus.viasoft.teste_1.servervices.CheckFazendaService;

@Service
public class CheckFazendaServiceImp implements CheckFazendaService {
	
	@Autowired
	private CheckFazendaRepository checkFazendaRepository;

	@Override
	@Transactional
	public CheckFazenda save(CheckFazenda entity) {
		return checkFazendaRepository.save(entity);
	}
	
	@Override
	public Optional<CheckFazenda> loadLast() {
		return checkFazendaRepository.findFirstByOrderByIdCheckDesc();
	}

	@Override
	public Page<CheckFazenda> loadAll(Pageable pageable) {
		return checkFazendaRepository.findAll(pageable);
	}

}
