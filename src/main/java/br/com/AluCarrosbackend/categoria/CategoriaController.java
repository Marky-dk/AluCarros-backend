package br.com.AluCarrosbackend.categoria;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/categoria")
@AllArgsConstructor
public class CategoriaController {

	@Autowired
	CategoriaRepository repository;
	
	@GetMapping("/retornaTodos")
	List<Categoria> todasCategorias(){
		return repository.findAll();
	}
	
	@PostMapping("/novo")
	Categoria novaCategoria(@RequestBody Categoria categoria) {
		return repository.save(categoria);
	}
	
	@GetMapping("/{id}")
	Optional<Categoria> retornaCategoria(@PathVariable Long id) {
		return repository.findById(id);
	}
	
	@PutMapping("/{id}")
	Categoria atualiza(@RequestBody Categoria categoria, @PathVariable Long id) {
		
		categoria.setId(id);
		return repository.save(categoria);
		
	}
	
	@DeleteMapping("/deleta/{id}")
	void deletaCategoria(@PathVariable long id) {
		repository.deleteById(id);
	}
}
