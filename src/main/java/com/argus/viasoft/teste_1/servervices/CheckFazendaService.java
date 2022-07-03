package com.argus.viasoft.teste_1.servervices;

import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import com.argus.viasoft.teste_1.models.CheckFazenda;

public interface CheckFazendaService {

	CheckFazenda save(CheckFazenda entity);

	Optional<CheckFazenda> loadLast();

	Page<CheckFazenda> loadAll(Pageable pageable);
}
