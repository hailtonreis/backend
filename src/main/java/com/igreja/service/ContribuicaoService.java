package com.igreja.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.igreja.entity.Contribuicao;

@Service
public interface ContribuicaoService {
	
	Contribuicao salvar(Contribuicao contribuicao);
	
	List<Contribuicao> listarTodos();
	
	Optional<Contribuicao> buscarPorId(Long contribuicaoId);
	
	Contribuicao atualizar(Long contribuicaoId, Contribuicao contribuicaoAtualizado);
	
	void deletar(Long contribuicaoId);
}
