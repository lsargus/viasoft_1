package com.argus.viasoft.teste_1.ropositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.argus.viasoft.teste_1.models.CheckFazenda;

@Repository
public interface CheckFazendaRepository extends JpaRepository<CheckFazenda, Long> {
	
    public Optional<CheckFazenda> findFirstByOrderByIdCheckDesc();

}
