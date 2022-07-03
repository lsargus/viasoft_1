package com.argus.viasoft.teste_1.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.argus.viasoft.teste_1.dtos.CheckFazendaAutorizadorDto;
import com.argus.viasoft.teste_1.dtos.CheckFazendaEtadosDto;
import com.argus.viasoft.teste_1.enums.FazendaAutorizador;
import com.argus.viasoft.teste_1.enums.UFs;
import com.argus.viasoft.teste_1.models.CheckFazenda;
import com.argus.viasoft.teste_1.models.CheckFazendaItens;
import com.argus.viasoft.teste_1.servervices.CheckFazendaItensService;
import com.argus.viasoft.teste_1.servervices.CheckFazendaService;
import com.argus.viasoft.teste_1.utils.CheckFazendaUtil;
import com.argus.viasoft.teste_1.utils.CountResult;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/checkFazenda")
public class CheckFazendaController {

	@Autowired
	private CheckFazendaService checkFazendaService;
	@Autowired
	private CheckFazendaItensService checkFazendaItensService;

	private static final String SEM_REGISTROS = "Não foram localizados registros.";

	@GetMapping
	public ResponseEntity<Object> currentStatus() {
		var check = checkFazendaService.loadLast();
		List<CheckFazendaEtadosDto> dtos = new ArrayList<>();

		var response = ResponseEntity.status(HttpStatus.OK);
		if (check.isEmpty())
			return response.body(SEM_REGISTROS);

		List<CheckFazendaItens> itens = checkFazendaItensService.loadByCheckFazenda(check.get());

		for (UFs uf : UFs.values()) {
			var dto = new CheckFazendaEtadosDto(uf, check.get());
			List<FazendaAutorizador> listAut = CheckFazendaUtil.autorizadoresByUF(uf);
			itens.stream().filter(v -> listAut.contains(v.getPk().getAutorizador()))
					.forEach(v -> dto.addAutorizador(new CheckFazendaAutorizadorDto(v)));

			dtos.add(dto);
		}

		return response.body(dtos);
	}

	@GetMapping("/{uf}")
	public ResponseEntity<Object> currentStatusByUF(@PathVariable(value = "uf") String uf) {

		List<FazendaAutorizador> aut = CheckFazendaUtil.autorizadoresByUF(uf);

		if (aut.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Nenum dado localizado para a uf informada.");

		var check = checkFazendaService.loadLast();

		var response = ResponseEntity.status(HttpStatus.OK);
		if (check.isEmpty())
			return response.body(SEM_REGISTROS);

		CheckFazenda cf = check.get();
		cf.setItens(checkFazendaItensService.loadByCheckFazendaAutorizador(cf, aut));

		var dto = new CheckFazendaEtadosDto(UFs.valueOf(uf), check.get());
		cf.getItens().stream().forEach(v -> dto.addAutorizador(new CheckFazendaAutorizadorDto(v)));

		return response.body(dto);
	}

	@GetMapping("/byDate/{uf}")
	public ResponseEntity<Object> findAllByUFOrderByDate(@PathVariable(value = "uf") String uf,
			@PageableDefault(page = 0, size = 10, sort = "dtCheck", direction = Direction.DESC) Pageable pageable) {

		List<FazendaAutorizador> aut = CheckFazendaUtil.autorizadoresByUF(uf);

		if (aut.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Nenum dado localizado para a uf informada.");

		var checks = checkFazendaService.loadAll(pageable);

		var response = ResponseEntity.status(HttpStatus.OK);
		if (checks.isEmpty())
			return response.body(SEM_REGISTROS);

		List<CheckFazendaEtadosDto> dtos = new ArrayList<>();
		for (CheckFazenda check : checks) {
			var dto = new CheckFazendaEtadosDto(UFs.valueOf(uf), check);
			checkFazendaItensService.loadByCheckFazendaAutorizador(check, aut).stream()
					.forEach(v -> dto.addAutorizador(new CheckFazendaAutorizadorDto(v)));

			dtos.add(dto);
		}

		return response.body(new PageImpl<>(dtos, pageable, dtos.size()));
	}

	@GetMapping("/instableUF")
	public ResponseEntity<String> findMostIstableUF() {
		CountResult<List<FazendaAutorizador>> count = checkFazendaItensService.findMostInstableAutorizador();

		if (count.getQuant() == 0L)
			return ResponseEntity.status(HttpStatus.OK).body("Não foram identificado instabilidades no período.");

		var sb = new StringBuilder("Os seguintes Autorizadores apresentaram ");
		sb.append(count.getQuant()).append(" indisponibilidade de serviço:").append(System.lineSeparator());

		count.getValores().forEach(v -> sb.append(v.toString()).append(System.lineSeparator()));
		
		return ResponseEntity.status(HttpStatus.OK).body(sb.toString());
	}
}
