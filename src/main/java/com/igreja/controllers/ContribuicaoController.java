package com.igreja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igreja.entity.Contribuicao;
import com.igreja.repository.ContribuicaoRepository;
import com.igreja.service.ContribuicaoService;

@RestController
@RequestMapping(value="/contribuicao")
public class ContribuicaoController {

	@Autowired
	private ContribuicaoService contribuicaoService;
	
	private final ContribuicaoRepository contribuicaoRepository;
	
	
	public ContribuicaoController(ContribuicaoRepository contribuicaoRepository) {
		this.contribuicaoRepository = contribuicaoRepository;
	}
	
	@PostMapping
	public List<Contribuicao> salvar(@RequestBody List<Contribuicao> contribuicoes) {
		return contribuicaoRepository.saveAll(contribuicoes);
	}
	
	@GetMapping
	public ResponseEntity<List<Contribuicao>> listarTodos() {
		List<Contribuicao> contribuicoes = contribuicaoService.listarTodos();
		
		return ResponseEntity.ok(contribuicoes);
	}
	
	@GetMapping("/{contribuicaoId}")
	public ResponseEntity<Contribuicao> buscarPorId(@PathVariable Long contribuicaoId) {
		
		return contribuicaoService.buscarPorId(contribuicaoId)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping("/{contribuicaoId}")
    public ResponseEntity<Contribuicao> atualizar(@PathVariable Long contribuicaoId, @RequestBody Contribuicao contribuicao) {
        try {
            Contribuicao atualizado = contribuicaoService.atualizar(contribuicaoId, contribuicao);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
	
	
	@DeleteMapping("/{contribuicaoId}")
	public ResponseEntity<Void> deletar(@PathVariable Long contribuicaoId) {
		try {
			contribuicaoService.deletar(contribuicaoId);
			return ResponseEntity.noContent().build();
		} catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
}
