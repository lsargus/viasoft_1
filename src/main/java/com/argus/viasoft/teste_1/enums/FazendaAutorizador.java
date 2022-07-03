package com.argus.viasoft.teste_1.enums;

public enum FazendaAutorizador {
	AM,
	BA,
	GO,
	MG,
	MS,
	MT,
	PE,
	PR,
	RS,
	SP,
	SVAN,
	SVRS,
	SVC_AN,
	SVC_RS;
	
	public static FazendaAutorizador getFromString(String str) {
		String value = str.toUpperCase().trim().replace("-", "_");
		
		return FazendaAutorizador.valueOf(value);
	}
}
