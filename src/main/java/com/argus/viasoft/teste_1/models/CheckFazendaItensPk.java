package com.argus.viasoft.teste_1.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.argus.viasoft.teste_1.enums.FazendaAutorizador;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Embeddable
public class CheckFazendaItensPk implements Serializable {

	private static final long serialVersionUID = -7044977757298679359L;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Id_Check", nullable = false)
	private CheckFazenda checkFazenda;
	

	@Column(name = "Autorizador", nullable = false)
	@Enumerated(EnumType.STRING)
	private FazendaAutorizador autorizador;

	public FazendaAutorizador getAutorizador() {
		return autorizador;
	}

	public void setAutorizador(FazendaAutorizador autorizador) {
		this.autorizador = autorizador;
	}

	public CheckFazenda getCheckFazenda() {
		return checkFazenda;
	}

	public void setCheckFazenda(CheckFazenda checkFazenda) {
		this.checkFazenda = checkFazenda;
	}
}
