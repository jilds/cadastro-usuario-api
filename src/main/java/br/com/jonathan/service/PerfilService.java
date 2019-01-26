package br.com.jonathan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.jonathan.model.ResponseModel;
import br.com.jonathan.model.PerfilModel;
import br.com.jonathan.repository.PerfilRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/service")
public class PerfilService {
	
	@Autowired
	private PerfilRepository perfilRepository;

	/**
	 * Salva um novo registro
	 * @param usuario
	 * @return
	 */
	@RequestMapping(value="/perfil", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel salvar(@RequestBody PerfilModel usuario){
		try {
			
			this.perfilRepository.save(usuario);
			
			return new ResponseModel(1,"Registro salvo com sucesso!");
			
		}catch(Exception e) {
			
			return new ResponseModel(0,e.getMessage());			
		}
	}
	
	/**
	 * Atualiza o registro de um usuario
	 * @param usuario
	 * @return
	 */
	@RequestMapping(value="/perfil", method = RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel atualizar(@RequestBody PerfilModel usuario){
		
		try {
			
			this.perfilRepository.save(usuario);		
			
			return new ResponseModel(1,"Registro atualizado com sucesso!");
		
		}catch(Exception e) {
			
			return new ResponseModel(0,e.getMessage());
		}
	}
	
	/**
	 * Consulta todos os usuários
	 * @return
	 */
	@RequestMapping(value="/perfil", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<PerfilModel> consultar(){
		return this.perfilRepository.findAll();
	}
	
	/**
	 * Busca usuario pelo codigo
	 * @param codigo
	 * @return
	 */
	@RequestMapping(value="/perfil/{codigo}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody PerfilModel buscar(@PathVariable("codigo") Integer codigo){
		return this.perfilRepository.findOne(codigo);
	}
	
	/**
	 * Exclui usuario pelo codigo
	 * @param codigo
	 * @return
	 */
	@RequestMapping(value="/perfil/{codigo}", method = RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel excluir(@PathVariable("codigo") Integer codigo){
		
		PerfilModel usuario = this.perfilRepository.findOne(codigo);
		
		try {
			
			this.perfilRepository.delete(usuario);
			
			return new ResponseModel(1, "Registro excluido com sucesso!");
			
		}catch(Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
	}
}
