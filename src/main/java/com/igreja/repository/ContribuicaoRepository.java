package com.igreja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igreja.entity.Contribuicao;

public interface ContribuicaoRepository extends JpaRepository <Contribuicao, Long> {
	

}
