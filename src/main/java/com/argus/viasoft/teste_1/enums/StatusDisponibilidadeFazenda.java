package com.argus.viasoft.teste_1.enums;

public enum StatusDisponibilidadeFazenda {
	R("Vermelho"),
	Y("Amarelo"),
	G("Verde");
	
	private String description;
	
	StatusDisponibilidadeFazenda(String description) {
		this.description = description;
	}
	
	public static StatusDisponibilidadeFazenda getFromImageName(String str) {
		if (str.contains("bola_vermelho"))
			return StatusDisponibilidadeFazenda.R;
		
		if (str.contains("bola_amarela"))
			return StatusDisponibilidadeFazenda.Y;
		
		return StatusDisponibilidadeFazenda.G;
	}

	public String getDescription() {
		return description;
	}
}
