package br.com.jonathan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "aparelhos")
@Entity
public class AparelhoModel {

	@Id
	@Column(name = "id_aparelho")
	@SequenceGenerator(name = "aparelho_seq", sequenceName = "aparelho_sequence", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aparelho_seq")
	private Integer codigo;

	@Column(name = "descricao_aparelho", length = 15)
	private String descricao;

	@Column(name = "codigo_aparelho", length = 100)
	private String codgAparelho;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCodgAparelho() {
		return codgAparelho;
	}

	public void setCodgAparelho(String codgAparelho) {
		this.codgAparelho = codgAparelho;
	}

	@Override
	public String toString() {
		return "AparelhoModel [codigo=" + codigo + ", descricao=" + descricao + ", codgAparelho=" + codgAparelho + "]";
	}

}
