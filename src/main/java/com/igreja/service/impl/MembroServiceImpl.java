package com.igreja.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.igreja.entity.Membro;
import com.igreja.repository.MembroRepository;
import com.igreja.service.MembroService;

@Service
public class MembroServiceImpl implements MembroService {

	private final MembroRepository membroRepository;
	
	public MembroServiceImpl(MembroRepository membroRepository) {
		this.membroRepository = membroRepository;
	}
	
	@Override
	public List<Membro> listarTodos() {
		return membroRepository.findAll();
	}
	
	@Override
	public Optional<Membro> buscarPorId(Long membroId) {
		return membroRepository.findById(membroId);
	}

	@Override
	public Membro salvar(Membro membro) {
		return membroRepository.save(membro);
	}
		
	@Override
	public Membro atualizar(Long membroId, Membro membroAtualizado) {
		Optional<Membro> membroExistente = membroRepository.findById(membroId);
		
		if(membroExistente.isPresent()) {
			Membro membro = membroExistente.get();
			membro.setNome(membroAtualizado.getNome());
			membro.setContato(membroAtualizado.getContato());
			membro.setEmail(membroAtualizado.getEmail());
			membro.setCpf(membroAtualizado.getCpf());
			membro.setEndereco(membroAtualizado.getEndereco());
			membro.setCidade(membroAtualizado.getCidade());
            membro.setDataNascimento(membroAtualizado.getDataNascimento());
            return membroRepository.save(membro);
		} else {
			throw new RuntimeException("Membro com ID " + membroId + " não encontrado.");
		}
	}
	
	public void deletar(Long membroId) {
		if(!membroRepository.existsById(membroId)){
			throw new RuntimeException("Membro com ID " + "não encontrado.");
		}
		membroRepository.deleteById(membroId);
	}

}
