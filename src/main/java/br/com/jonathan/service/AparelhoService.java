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

import br.com.jonathan.model.AparelhoModel;
import br.com.jonathan.model.ResponseModel;
import br.com.jonathan.repository.AparelhoRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/service")
public class AparelhoService {
	
	@Autowired
	private AparelhoRepository aparelhoService;

	/**
	 * Salva um novo registro
	 * @param usuario
	 * @return
	 */
	@RequestMapping(value="/aparelho", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel salvar(@RequestBody AparelhoModel usuario){
		try {
			
			this.aparelhoService.save(usuario);
			
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
	@RequestMapping(value="/aparelho", method = RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel atualizar(@RequestBody AparelhoModel usuario){
		
		try {
			
			this.aparelhoService.save(usuario);		
			
			return new ResponseModel(1,"Registro atualizado com sucesso!");
		
		}catch(Exception e) {
			
			return new ResponseModel(0,e.getMessage());
		}
	}
	
	/**
	 * Consulta todos os usuários
	 * @return
	 */
	@RequestMapping(value="/aparelho", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<AparelhoModel> consultar(){
		return this.aparelhoService.findAll();
	}
	
	/**
	 * Busca usuario pelo codigo
	 * @param codigo
	 * @return
	 */
	@RequestMapping(value="/aparelho/{codigo}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody AparelhoModel buscar(@PathVariable("codigo") Integer codigo){
		return this.aparelhoService.findOne(codigo);
	}
	
	/**
	 * Exclui usuario pelo codigo
	 * @param codigo
	 * @return
	 */
	@RequestMapping(value="/aparelho/{codigo}", method = RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel excluir(@PathVariable("codigo") Integer codigo){
		
		AparelhoModel usuario = this.aparelhoService.findOne(codigo);
		
		try {
			
			this.aparelhoService.delete(usuario);
			
			return new ResponseModel(1, "Registro excluido com sucesso!");
			
		}catch(Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
	}
}
