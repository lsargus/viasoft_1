package com.argus.viasoft.teste_1.dtos;

import com.argus.viasoft.teste_1.enums.FazendaAutorizador;
import com.argus.viasoft.teste_1.enums.StatusDisponibilidadeFazenda;
import com.argus.viasoft.teste_1.models.CheckFazendaItens;

public class CheckFazendaAutorizadorDto {

	private FazendaAutorizador autorizador;
	private StatusDisponibilidadeFazenda autorizacao4;
	private StatusDisponibilidadeFazenda retAutorizacao4;
	private StatusDisponibilidadeFazenda inutilizacao4;
	private StatusDisponibilidadeFazenda protocolo4;
	private StatusDisponibilidadeFazenda statusServ4;
	private String tempoMedio;
	private StatusDisponibilidadeFazenda cadastro4;
	private StatusDisponibilidadeFazenda recepcaoEvento4;

	public CheckFazendaAutorizadorDto(CheckFazendaItens item) {
		this.autorizador = item.getPk().getAutorizador();
		this.autorizacao4 = item.getAutorizacao4();
		this.retAutorizacao4 = item.getRetAutorizacao4();
		this.inutilizacao4 = item.getInutilizacao4();
		this.protocolo4 = item.getProtocolo4();
		this.statusServ4 = item.getStatusServ4();
		this.tempoMedio = item.getTempo();
		this.cadastro4 = item.getCadastro4();
		this.recepcaoEvento4 = item.getRecepcaoEvento4();
	}

	public FazendaAutorizador getAutorizador() {
		return autorizador;
	}

	public void setAutorizador(FazendaAutorizador autorizador) {
		this.autorizador = autorizador;
	}

	public StatusDisponibilidadeFazenda getAutorizacao4() {
		return autorizacao4;
	}

	public void setAutorizacao4(StatusDisponibilidadeFazenda autorizacao4) {
		this.autorizacao4 = autorizacao4;
	}

	public StatusDisponibilidadeFazenda getRetAutorizacao4() {
		return retAutorizacao4;
	}

	public void setRetAutorizacao4(StatusDisponibilidadeFazenda retAutorizacao4) {
		this.retAutorizacao4 = retAutorizacao4;
	}

	public StatusDisponibilidadeFazenda getInutilizacao4() {
		return inutilizacao4;
	}

	public void setInutilizacao4(StatusDisponibilidadeFazenda inutilizacao4) {
		this.inutilizacao4 = inutilizacao4;
	}

	public StatusDisponibilidadeFazenda getProtocolo4() {
		return protocolo4;
	}

	public void setProtocolo4(StatusDisponibilidadeFazenda protocolo4) {
		this.protocolo4 = protocolo4;
	}

	public StatusDisponibilidadeFazenda getStatusServ4() {
		return statusServ4;
	}

	public void setStatusServ4(StatusDisponibilidadeFazenda statusServ4) {
		this.statusServ4 = statusServ4;
	}

	public String getTempoMedio() {
		return tempoMedio;
	}

	public void setTempoMedio(String tempoMedio) {
		this.tempoMedio = tempoMedio;
	}

	public StatusDisponibilidadeFazenda getCadastro4() {
		return cadastro4;
	}

	public void setCadastro4(StatusDisponibilidadeFazenda cadastro4) {
		this.cadastro4 = cadastro4;
	}

	public StatusDisponibilidadeFazenda getRecepcaoEvento4() {
		return recepcaoEvento4;
	}

	public void setRecepcaoEvento4(StatusDisponibilidadeFazenda recepcaoEvento4) {
		this.recepcaoEvento4 = recepcaoEvento4;
	}
}
