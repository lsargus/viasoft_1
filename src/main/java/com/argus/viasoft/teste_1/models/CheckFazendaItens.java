package com.argus.viasoft.teste_1.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.argus.viasoft.teste_1.enums.StatusDisponibilidadeFazenda;

@Entity
@Table(name = "Check_Fazenda_Itens")
public class CheckFazendaItens implements Serializable {

	private static final long serialVersionUID = -1347655058867165248L;

	@EmbeddedId
	private CheckFazendaItensPk pk;
	
	@Column(name = "Autorizacao_4", length = 1)
	@Enumerated(EnumType.STRING)
	private StatusDisponibilidadeFazenda autorizacao4;
	
	@Column(name = "Retorno_Autorizacao_4", length = 1)
	@Enumerated(EnumType.STRING)
	private StatusDisponibilidadeFazenda retAutorizacao4;
	
	@Column(name = "Inutilizacao_4", length = 1)
	@Enumerated(EnumType.STRING)
	private StatusDisponibilidadeFazenda inutilizacao4;
	
	@Column(name = "Consulta_Protocolo_4", length = 1)
	@Enumerated(EnumType.STRING)
	private StatusDisponibilidadeFazenda protocolo4;
	
	@Column(name = "Status_Servico_4", length = 1)
	@Enumerated(EnumType.STRING)
	private StatusDisponibilidadeFazenda statusServ4;
	
	@Column(name = "Tempo_Medio")
	private String tempo;
	
	@Column(name = "Consulta_Cadastro_4", length = 1)
	@Enumerated(EnumType.STRING)
	private StatusDisponibilidadeFazenda cadastro4;
	
	@Column(name = "Recepcao_Evento_4", length = 1)
	@Enumerated(EnumType.STRING)
	private StatusDisponibilidadeFazenda recepcaoEvento4;

	public CheckFazendaItens() {
		pk = new CheckFazendaItensPk();
	}
	
	public CheckFazendaItensPk getPk() {
		return pk;
	}

	public void setPk(CheckFazendaItensPk pk) {
		this.pk = pk;
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

	public String getTempo() {
		return tempo;
	}

	public void setTempo(String tempo) {
		this.tempo = tempo;
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
