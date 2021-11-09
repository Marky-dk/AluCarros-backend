package br.com.AluCarrosbackend.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.sun.istack.NotNull;

import br.com.AluCarrosbackend.categoria.Categoria;
import br.com.AluCarrosbackend.loja.Loja;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Modelo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@NotNull
	@Column(name = "marca")
	private String marca;
	@NotNull
	@Column(name = "ano")
	private String ano;
	@NotNull
	@Column(name = "nome")
	private String nome;
	@NotNull
	@Column(name = "placa")
	private String placa;
	
	@OneToMany(mappedBy = "modelo", targetEntity = Loja.class, cascade = CascadeType.ALL)
	private List<Loja> loja;
		
	@OneToMany(mappedBy = "modelo", targetEntity = Categoria.class, cascade = CascadeType.ALL)
	private List<Categoria> categoria;
	
	public List<Loja> getLoja() {
		return loja;
	}
	
	public void setLoja(List<Loja> loja) {
		this.loja = loja;
	}
	
	public List<Categoria> getCategoria() {
		return categoria;
	}
	
	public void setCategoria(List<Categoria> categoria) {
		this.categoria = categoria;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getAno() {
		return ano;
	}
	
	public void setAno(String ano) {
		this.ano = ano;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public String getPlaca() {
		return placa;
	}
	
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	

}
