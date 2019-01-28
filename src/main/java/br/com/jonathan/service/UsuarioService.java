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
import br.com.jonathan.model.UsuarioModel;
import br.com.jonathan.repository.UsuarioRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/service")
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	/**
	 * Salva um novo registro
	 * 
	 * @param usuario
	 * @return
	 */
	@RequestMapping(value = "/usuario", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel salvar(@RequestBody UsuarioModel usuario) {
		try {
			
			this.usuarioRepository.save(usuario);

			return new ResponseModel(1, "Registro salvo com sucesso!");

		} catch (Exception e) {

			return new ResponseModel(0, e.getMessage());
		}
	}

	/**
	 * Atualiza o registro de um usuario
	 * 
	 * @param usuario
	 * @return
	 */
	@RequestMapping(value = "/usuario", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel atualizar(@RequestBody UsuarioModel usuario) {

		try {

			this.usuarioRepository.save(usuario);

			return new ResponseModel(1, "Registro atualizado com sucesso!");

		} catch (Exception e) {

			return new ResponseModel(0, e.getMessage());
		}
	}

	/**
	 * Consulta todos os usuários
	 * 
	 * @return
	 */
	@RequestMapping(value = "/usuario", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<UsuarioModel> consultar() {
		return this.usuarioRepository.findAll();
	}

	/**
	 * Busca usuario pelo codigo
	 * 
	 * @param codigo
	 * @return
	 */
	@RequestMapping(value = "/usuario/{codigo}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody UsuarioModel buscar(@PathVariable("codigo") Integer codigo) {
		return this.usuarioRepository.findOne(codigo);
	}

	/**
	 * Exclui usuario pelo codigo
	 * 
	 * @param codigo
	 * @return
	 */
	@RequestMapping(value = "/usuario/{codigo}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel excluir(@PathVariable("codigo") Integer codigo) {

		UsuarioModel usuario = this.usuarioRepository.findOne(codigo);

		try {

			this.usuarioRepository.delete(usuario);

			return new ResponseModel(1, "Registro excluido com sucesso!");

		} catch (Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
	}
}
