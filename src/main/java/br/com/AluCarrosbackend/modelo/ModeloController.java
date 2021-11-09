package br.com.AluCarrosbackend.modelo;

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
@RequestMapping("/modelo")
@AllArgsConstructor
public class ModeloController {

	@Autowired
	ModeloRepository repository;
	
	@GetMapping("/retornaTodos")
	List<Modelo> todosModelos(){
		return repository.findAll();
	}
	
	@PostMapping("/novo")
	Modelo novoModelo(@RequestBody Modelo modelo) {
		return repository.save(modelo);
	}
	
	@GetMapping("/{id}")
	Optional<Modelo> retornaModelo(@PathVariable Long id){
		return repository.findById(id);
	}
	
	@PutMapping("/{id}")
	Modelo atualizaModelo(@RequestBody Modelo modelo, @PathVariable Long id) {
		modelo.setId(id);
		return repository.save(modelo);
	}
	
	@DeleteMapping("/deleta/{id}")
	void deletaModelo(@PathVariable long id) {
		repository.deleteById(id);
	}
}
