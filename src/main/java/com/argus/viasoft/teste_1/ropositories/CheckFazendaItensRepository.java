package com.argus.viasoft.teste_1.ropositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.argus.viasoft.teste_1.enums.FazendaAutorizador;
import com.argus.viasoft.teste_1.models.CheckFazenda;
import com.argus.viasoft.teste_1.models.CheckFazendaItens;
import com.argus.viasoft.teste_1.models.CheckFazendaItensPk;

@Repository
public interface CheckFazendaItensRepository extends JpaRepository<CheckFazendaItens, CheckFazendaItensPk> {

	List<CheckFazendaItens> findByPkCheckFazenda(CheckFazenda checkFazenda);

	@Query("SELECT COUNT(c) FROM CheckFazendaItens c WHERE c.pk.autorizador = ?1 AND "
			+ "(autorizacao4 = 'R' OR retAutorizacao4 = 'R' OR inutilizacao4 = 'R' OR "
			+ "protocolo4 = 'R' OR statusServ4 = 'R' OR cadastro4 = 'R' OR recepcaoEvento4= 'R')")
	long countByPkAutorizadorFail(FazendaAutorizador aut);

}
