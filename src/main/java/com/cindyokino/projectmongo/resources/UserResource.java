package com.cindyokino.projectmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cindyokino.projectmongo.domain.Post;
import com.cindyokino.projectmongo.domain.User;
import com.cindyokino.projectmongo.dto.UserDTO;
import com.cindyokino.projectmongo.services.UserService;

@RestController // indica que a classe é um recurso REST
@RequestMapping(value="/users") // indica qual o caminho do endpoint
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method=RequestMethod.GET) // indica que o método vai ser o endpoint REST no caminho /users
	public ResponseEntity<List<UserDTO>> findAll() { // ResponseEntity<T> encapsula para retornar respostas HTTP
		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto); // instanciar ResponseEntity<T>
	}	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET) // indica que o método vai ser o endpoint REST no caminho /users
	public ResponseEntity<UserDTO> findById(@PathVariable String id) { // ResponseEntity<T> encapsula para retornar respostas HTTP
		User obj = service.findById(id);		
		return ResponseEntity.ok().body(new UserDTO(obj)); // instanciar ResponseEntity<T>
	}
	
	@RequestMapping(method=RequestMethod.POST) // ou usar so @PostMapping
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) {
		User obj = service.fromDTO(objDto);	
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri(); // pega o endereco do novo objeto inserido 
		return ResponseEntity.created(uri).build(); // retorna uma resposta vazia com o codigo 201 e com o cabecalho contendo a localizacao do novo recurso criado
	}	
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.deleteById(id);		
		return ResponseEntity.noContent().build(); // noContent() = codigo 204
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody UserDTO objDto, @PathVariable String id) {
		User obj = service.fromDTO(objDto);	
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build(); // noContent() = codigo 204
		}	
	
	@RequestMapping(value="/{id}/posts", method=RequestMethod.GET)
	public ResponseEntity<List<Post>> findPosts(@PathVariable String id) { // ResponseEntity<T> encapsula para retornar respostas HTTP
		User obj = service.findById(id);		
		return ResponseEntity.ok().body(obj.getPosts());
	}
}
