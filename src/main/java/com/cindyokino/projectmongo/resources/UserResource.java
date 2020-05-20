package com.cindyokino.projectmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cindyokino.projectmongo.domain.User;

@RestController // indica que a classe é um recurso REST
@RequestMapping(value="/users") // indica qual o caminho do endpoint
public class UserResource {
	
	@RequestMapping(method=RequestMethod.GET) // indica que o método vai ser o endpoint REST no caminho /users
	public ResponseEntity<List<User>> findAll() { // ResponseEntity<T> encapsula para retornar respostas HTTP
		User maria = new User("1", "Maria Brown", "maria@gmail.com");
		User alex = new User("2", "Alex Green ", "alex@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria, alex));
		return ResponseEntity.ok().body(list); // instanciar ResponseEntity<T>
	}
}
