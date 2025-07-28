package com.igreja.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.igreja.entity.Contribuicao;
import com.igreja.repository.ContribuicaoRepository;
import com.igreja.service.ContribuicaoService;

@Service
public class ContribuicaoServiceImpl implements ContribuicaoService{
	
	private final ContribuicaoRepository contribuicaoRepository;
	
	public ContribuicaoServiceImpl(ContribuicaoRepository contribuicaoRepository) {
		this.contribuicaoRepository = contribuicaoRepository;
	}
	
	@Override
	public List<Contribuicao> listarTodos() {
		return contribuicaoRepository.findAll();
	}
	
	@Override
	public Optional<Contribuicao> buscarPorId(Long contribuicaoId) {
		return contribuicaoRepository.findById(contribuicaoId);
	}
	
	
	@Override
	public Contribuicao atualizar(Long contribuicaoId, Contribuicao contribuicaoAtualizado) {
		Optional<Contribuicao> contribuicaoExistente = contribuicaoRepository.findById(contribuicaoId);
		
		if(contribuicaoExistente.isPresent()) {
			Contribuicao contribuicao = contribuicaoExistente.get();
			contribuicao.setDataAtualizacao(contribuicaoAtualizado.getDataAtualizacao());
			contribuicao.setDataReferencia(contribuicaoAtualizado.getDataReferencia());
			contribuicao.setTipoContribuicao(contribuicaoAtualizado.getTipoContribuicao());
			contribuicao.setFormaContribuicao(contribuicaoAtualizado.getFormaContribuicao());
			contribuicao.setValor(contribuicaoAtualizado.getValor());
			contribuicao.setDescricao(contribuicaoAtualizado.getDescricao());
			contribuicao.setMembro(contribuicaoAtualizado.getMembro());
			
            return contribuicaoRepository.save(contribuicao);
		} else {
			throw new RuntimeException("Contribuição com ID " + contribuicaoId + " não encontrado.");
		}
	}
	
	public void deletar(Long contribuicaoId) {
		if(!contribuicaoRepository.existsById(contribuicaoId)){
			throw new RuntimeException("Contribuição com ID " + "não encontrado.");
		}
		contribuicaoRepository.deleteById(contribuicaoId);
	}

	@Override
	public Contribuicao salvar(Contribuicao contribuicao) {
		return contribuicaoRepository.save(contribuicao);
	}
	
}
