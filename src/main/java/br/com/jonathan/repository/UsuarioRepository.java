package br.com.jonathan.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import br.com.jonathan.model.UsuarioModel;

public interface UsuarioRepository extends Repository<UsuarioModel, Integer> {

	void save(UsuarioModel pessoa);
	
	void delete(UsuarioModel pessoa);
	
	List<UsuarioModel> findAll();
	
	UsuarioModel findOne(Integer id);
	
}
