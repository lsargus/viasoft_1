package com.argus.viasoft.teste_1.utils;

import java.util.ArrayList;
import java.util.List;

import com.argus.viasoft.teste_1.enums.FazendaAutorizador;
import com.argus.viasoft.teste_1.enums.UFs;

public class CheckFazendaUtil {

	private CheckFazendaUtil() {
		throw new IllegalStateException("Utility class");
	}

	public static List<FazendaAutorizador> autorizadoresByUF(UFs ufs) {
		return autorizadoresByUF(ufs.toString());
	}
	public static List<FazendaAutorizador> autorizadoresByUF(String ufs) {
		List<FazendaAutorizador> result = new ArrayList<>();
		UFs uf = ufValida(ufs);
		if (uf != null) {
			switch (uf) {
			case AM:
				result.add(FazendaAutorizador.AM);
				result.add(FazendaAutorizador.SVC_RS);
				break;
			case BA:
				result.add(FazendaAutorizador.BA);
				result.add(FazendaAutorizador.SVC_RS);
				break;
			case GO:
				result.add(FazendaAutorizador.GO);
				result.add(FazendaAutorizador.SVC_RS);
				break;
			case MG:
				result.add(FazendaAutorizador.MG);
				result.add(FazendaAutorizador.SVC_AN);
				break;
			case MS:
				result.add(FazendaAutorizador.MS);
				result.add(FazendaAutorizador.SVC_RS);
				break;
			case MT:
				result.add(FazendaAutorizador.MT);
				result.add(FazendaAutorizador.SVC_RS);
				break;
			case PE:
				result.add(FazendaAutorizador.PE);
				result.add(FazendaAutorizador.SVC_RS);
				break;
			case PR:
				result.add(FazendaAutorizador.PR);
				result.add(FazendaAutorizador.SVC_RS);
				break;
			case RS:
				result.add(FazendaAutorizador.RS);
				result.add(FazendaAutorizador.SVRS);
				result.add(FazendaAutorizador.SVC_AN);
				break;
			case SP:
				result.add(FazendaAutorizador.SP);
				break;
			case MA:
				result.add(FazendaAutorizador.SVAN);
				result.add(FazendaAutorizador.SVC_RS);
				break;
			default:
				result.add(FazendaAutorizador.SVRS);
				result.add(FazendaAutorizador.SVC_AN);
				break;
			}
		}
		return result;
	}

	public static UFs ufByAutorizadores(FazendaAutorizador aut) {
		switch (aut) {
		case AM:
			return UFs.AM;
		case BA:
			return UFs.BA;
		case GO:
			return UFs.GO;
		case MG:
			return UFs.MG;
		case MS:
			return UFs.MS;
		case MT:
			return UFs.MT;
		case PE:
			return UFs.PE;
		case PR:
			return UFs.PR;
		case RS:
			return UFs.RS;
		case SP:
			return UFs.SP;
		case SVAN:
			return UFs.MA;
		default:
			return null;
		}
	}

	public static UFs ufValida(String str) {
		if (str.isEmpty() || str.length() != 2)
			return null;
		try {
			return UFs.valueOf(str.toUpperCase());
		} catch (IllegalArgumentException e) {
			return null;
		}

	}
}
