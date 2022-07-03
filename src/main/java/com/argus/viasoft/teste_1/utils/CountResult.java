package com.argus.viasoft.teste_1.utils;

public class CountResult<T> {

	private T valores;
	private long quant;

	public CountResult(T valores, long quant) {
		this.valores = valores;
		this.quant = quant;
	}

	public T getValores() {
		return valores;
	}

	public void setValores(T valores) {
		this.valores = valores;
	}

	public long getQuant() {
		return quant;
	}

	public void setQuant(long quant) {
		this.quant = quant;
	}

}
