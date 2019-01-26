package br.com.jonathan.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import br.com.jonathan.model.AparelhoModel;

public interface AparelhoRepository extends Repository<AparelhoModel, Integer> {

	void save(AparelhoModel pessoa);
	
	void delete(AparelhoModel pessoa);
	
	List<AparelhoModel> findAll();
	
	AparelhoModel findOne(Integer id);
	
}
