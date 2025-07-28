package com.igreja.repository;
import com.igreja.entity.Membro;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembroRepository extends JpaRepository<Membro, Long> {

	List<Membro> findByNomeContainingIgnoreCase(String nome);
	
	List<Membro> findByCpfContainingIgnoreCase(String cpf);
	    
//	 List<Membro> findByIdadeGreaterThanEqual(Integer idade);
	
}
