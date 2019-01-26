package br.com.jonathan.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "USUARIOS")
public class UsuarioModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_usuario", length = 8)
	private Integer codigo;

	@Column(name = "nome_usuario", length = 60)
	private String nome;

	@Column(name = "login", length = 14)
	private String login;

	@Column(name = "email", length = 60)
	private String email;

	@Column(name = "senha", length = 45)
	private String senha;

	@Column(name = "data_criacao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCricao = new Date();

	@Column(name = "tempo_expiracao_senha", length = 4)
	private int tempoExpiracaoSenha;

	@Column(name = "cod_autorizacao", length = 1)
	private int codgAutorizacao;

	@Column(name = "status_usuario")
	private boolean situacaoUsuario;

	@Column(name = "cod_pessoa", length = 8)
	private int codgPessoa;

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH,
			CascadeType.PERSIST })
	@JoinTable(name = "usuarios_perfil", joinColumns = { @JoinColumn(name = "id_usuario") }, inverseJoinColumns = {
			@JoinColumn(name = "id_perfil") })
	private Set<PerfilModel> listaPerfil = new HashSet<>();

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH,
			CascadeType.PERSIST })
	@JoinTable(name = "usuarios_aparelhos", joinColumns = { @JoinColumn(name = "id_usuario") }, inverseJoinColumns = {
			@JoinColumn(name = "id_aparelho") })
	private Set<AparelhoModel> listaAparelhos = new HashSet<>();

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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getDataCricao() {
		return dataCricao;
	}

	public void setDataCricao(Date dataCricao) {
		this.dataCricao = dataCricao;
	}

	public int getTempoExpiracaoSenha() {
		return tempoExpiracaoSenha;
	}

	public void setTempoExpiracaoSenha(int tempoExpiracaoSenha) {
		this.tempoExpiracaoSenha = tempoExpiracaoSenha;
	}

	public int getCodgAutorizacao() {
		return codgAutorizacao;
	}

	public void setCodgAutorizacao(int codgAutorizacao) {
		this.codgAutorizacao = codgAutorizacao;
	}

	public boolean getSituacaoUsuario() {
		return situacaoUsuario;
	}

	public void setSituacaoUsuario(boolean situacaoUsuario) {
		this.situacaoUsuario = situacaoUsuario;
	}

	public int getCodgPessoa() {
		return codgPessoa;
	}

	public void setCodgPessoa(int codgPessoa) {
		this.codgPessoa = codgPessoa;
	}

	public Set<PerfilModel> getListaPerfil() {
		return listaPerfil;
	}

	public void setListaPerfil(Set<PerfilModel> listaPerfil) {
		this.listaPerfil = listaPerfil;
	}

	public Set<AparelhoModel> getListaAparelhos() {
		return listaAparelhos;
	}

	public void setListaAparelhos(Set<AparelhoModel> listaAparelhos) {
		this.listaAparelhos = listaAparelhos;
	}

	@Override
	public String toString() {
		return "UsuarioModel [codigo=" + codigo + ", nome=" + nome + ", login=" + login + ", email=" + email
				+ ", senha=" + senha + ", dataCricao=" + dataCricao + ", tempoExpiracaoSenha=" + tempoExpiracaoSenha
				+ ", codgAutorizacao=" + codgAutorizacao + ", situacaoUsuario=" + situacaoUsuario + ", codgPessoa="
				+ codgPessoa + "]";
	}
}