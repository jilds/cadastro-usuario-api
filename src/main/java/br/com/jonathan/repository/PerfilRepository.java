package br.com.jonathan.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import br.com.jonathan.model.PerfilModel;

public interface PerfilRepository extends Repository<PerfilModel, Integer> {

	void save(PerfilModel pessoa);
	
	void delete(PerfilModel pessoa);
	
	List<PerfilModel> findAll();
	
	PerfilModel findOne(Integer id);
	
}
