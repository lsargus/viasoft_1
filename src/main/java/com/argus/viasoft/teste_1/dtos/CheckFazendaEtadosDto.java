package com.argus.viasoft.teste_1.dtos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.argus.viasoft.teste_1.enums.UFs;
import com.argus.viasoft.teste_1.models.CheckFazenda;

public class CheckFazendaEtadosDto {

	private UFs uf;
	private LocalDateTime dtCheck;
	private List<CheckFazendaAutorizadorDto> autorizadores;

	public CheckFazendaEtadosDto(UFs uf, CheckFazenda check) {
		this.uf = uf;
		this.dtCheck = check.getDtCheck();
		this.autorizadores = new ArrayList<>();
	}
	
	public void addAutorizador(CheckFazendaAutorizadorDto aut) {
		this.autorizadores.add(aut);
	}

	public UFs getUf() {
		return uf;
	}

	public void setUf(UFs uf) {
		this.uf = uf;
	}

	public LocalDateTime getDtCheck() {
		return dtCheck;
	}

	public void setDtCheck(LocalDateTime dtCheck) {
		this.dtCheck = dtCheck;
	}

	public List<CheckFazendaAutorizadorDto> getAutorizadores() {
		return autorizadores;
	}

	public void setAutorizadores(List<CheckFazendaAutorizadorDto> autorizadores) {
		this.autorizadores = autorizadores;
	}

}
