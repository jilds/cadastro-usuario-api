package br.com.jonathan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name="perfil")
@Entity
public class PerfilModel {
	
	@Id
	@Column(name = "id_perfil")
	@SequenceGenerator(name = "perfil_seq", sequenceName = "perfil_sequence", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "perfil_seq")
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
