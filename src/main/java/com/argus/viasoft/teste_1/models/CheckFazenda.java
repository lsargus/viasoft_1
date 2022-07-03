package com.argus.viasoft.teste_1.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.argus.viasoft.teste_1.enums.StatusCheckFazenda;

@Entity
@Table(name = "Check_Fazenda")
public class CheckFazenda implements Serializable {

	private static final long serialVersionUID = 3013481918355914809L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id_Check", nullable = false, unique = true)
	private Long idCheck;
	
	@Column(name = "Status")
	@Enumerated(EnumType.ORDINAL)
	private StatusCheckFazenda status;
	
	@Column(name = "Date_Check")
	private LocalDateTime dtCheck;
	
	@OneToMany(mappedBy = "pk.checkFazenda", targetEntity = CheckFazendaItens.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	 private List<CheckFazendaItens> itens;
	
	public Long getIdCheck() {
		return idCheck;
	}

	public void setIdCheck(Long idCheck) {
		this.idCheck = idCheck;
	}

	public StatusCheckFazenda getStatus() {
		return status;
	}

	public void setStatus(StatusCheckFazenda status) {
		this.status = status;
	}

	public LocalDateTime getDtCheck() {
		return dtCheck;
	}

	public void setDtCheck(LocalDateTime dtCheck) {
		this.dtCheck = dtCheck;
	}

	public List<CheckFazendaItens> getItens() {
		return itens;
	}

	public void setItens(List<CheckFazendaItens> itens) {
		this.itens = itens;
	}
}
