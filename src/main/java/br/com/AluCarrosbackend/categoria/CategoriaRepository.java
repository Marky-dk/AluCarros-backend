package br.com.AluCarrosbackend.categoria;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
	List<Categoria> findAllByModelo(Long id);

}
