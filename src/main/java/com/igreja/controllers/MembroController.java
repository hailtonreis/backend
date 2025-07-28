package com.igreja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.igreja.entity.Membro;
import com.igreja.repository.MembroRepository;
import com.igreja.service.MembroService;

@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
@RequestMapping("/membro")
public class MembroController {
	
	@Autowired
	private MembroService membroService;
	
	private final MembroRepository membroRepository;
	
	public MembroController(MembroRepository membroRepository) {
		this.membroRepository = membroRepository;
	}
	
	@GetMapping
	public ResponseEntity<List<Membro>> listarTodos() {
		List<Membro> membros = membroService.listarTodos();
		
		return ResponseEntity.ok(membros);
	}
	
	@GetMapping("/buscarPorNome")
	public List<Membro> buscarPorNome(@RequestParam String nome) {
		
		return membroRepository.findByNomeContainingIgnoreCase(nome);
	}
	
	@GetMapping("/buscarPorCpf")
	public List<Membro> buscarPorCpf(@RequestParam String cpf) {
		
		return membroRepository.findByCpfContainingIgnoreCase(cpf);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Membro> buscarPorId(@PathVariable Long id) {
		
		return membroService.buscarPorId(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	
	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody Membro membro) {
		membroService.salvar(membro);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<Membro> atualizar(@PathVariable Long id, @RequestBody Membro membro) {
        try {
            Membro atualizado = membroService.atualizar(id, membro);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
	
		@DeleteMapping("/{id}")
		public ResponseEntity<Void> deletar(@PathVariable Long id) {
			try {
				membroService.deletar(id);
				return ResponseEntity.noContent().build();
			} catch (RuntimeException e) {
				return ResponseEntity.notFound().build();
			}
			
		}
	}