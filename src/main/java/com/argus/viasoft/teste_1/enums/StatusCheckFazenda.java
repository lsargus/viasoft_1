package com.argus.viasoft.teste_1.enums;

public enum StatusCheckFazenda {
	
	OK("Consulta bem sucedida"),
	FAIL("Erro ao realizar consulta");
	
	private String description;
	
	StatusCheckFazenda(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
