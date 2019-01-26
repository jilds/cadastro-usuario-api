package br.com.jonathan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="perfil")
@Entity
public class PerfilModel {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="id_perfil", length = 8)
	private Integer codigo;
	
	@Column(name="nome_perfil", length = 60)
	private String  nome;
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return "PerfilModel [codigo=" + codigo + ", nome=" + nome + "]";
	}

}
