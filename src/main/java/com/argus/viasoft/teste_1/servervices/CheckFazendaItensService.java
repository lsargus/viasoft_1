package com.argus.viasoft.teste_1.servervices;

import java.util.List;

import com.argus.viasoft.teste_1.enums.FazendaAutorizador;
import com.argus.viasoft.teste_1.models.CheckFazenda;
import com.argus.viasoft.teste_1.models.CheckFazendaItens;
import com.argus.viasoft.teste_1.utils.CountResult;

public interface CheckFazendaItensService {

	List<CheckFazendaItens> loadByCheckFazenda(CheckFazenda check);

	List<CheckFazendaItens> loadByCheckFazendaAutorizador(CheckFazenda check, List<FazendaAutorizador> autorizadores);

	CountResult<List<FazendaAutorizador>> findMostInstableAutorizador();

}
