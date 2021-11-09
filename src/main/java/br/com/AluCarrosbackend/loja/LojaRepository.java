package br.com.AluCarrosbackend.loja;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface LojaRepository extends JpaRepository<Loja, Long> {
	
	List<Loja> findAllByModelo(Long id);

}
