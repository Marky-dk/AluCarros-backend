package br.com.AluCarrosbackend.loja;

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
@RequestMapping("/loja")
@AllArgsConstructor
public class LojaController {
	
	@Autowired
	LojaRepository repository;
	
	@GetMapping("/retornaTodos")
	List<Loja> todasLojas(){
		return repository.findAll();
	}
	
	@PostMapping("/novo")
	Loja novaLoja(@RequestBody Loja loja) {
		return repository.save(loja);
	}
	
	@GetMapping("/{id}")
	Optional<Loja> retornaLoja(@PathVariable Long id){
		return repository.findById(id);
	}
	
	@PutMapping("/{id}")
	Loja atualizaLoja(@RequestBody Loja loja, @PathVariable Long id) {
		loja.setId(id);
		return repository.save(loja);
	}
	
	@DeleteMapping("/deleta/{id}")
	void deletaLoja(@PathVariable long id) {
		repository.deleteById(id);
	}

}
