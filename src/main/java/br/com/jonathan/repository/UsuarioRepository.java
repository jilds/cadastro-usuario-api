package br.com.jonathan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jonathan.model.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {

	/*void save(UsuarioModel pessoa);
	
	void delete(UsuarioModel pessoa);
	
	List<UsuarioModel> findAll();
	
	UsuarioModel findOne(Integer id);*/
	
}
