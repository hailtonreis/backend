package com.igreja.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.igreja.entity.Membro;

@Service
public interface MembroService {

	Membro salvar(Membro membro);
	
	List<Membro> listarTodos();
	
	Optional<Membro> buscarPorId(Long membroId);
	
	Membro atualizar(Long membroId, Membro membroAtualizado);
	
	void deletar(Long contribuicaoId);
}
