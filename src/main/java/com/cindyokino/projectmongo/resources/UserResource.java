package com.cindyokino.projectmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cindyokino.projectmongo.domain.User;
import com.cindyokino.projectmongo.services.UserService;

@RestController // indica que a classe é um recurso REST
@RequestMapping(value="/users") // indica qual o caminho do endpoint
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method=RequestMethod.GET) // indica que o método vai ser o endpoint REST no caminho /users
	public ResponseEntity<List<User>> findAll() { // ResponseEntity<T> encapsula para retornar respostas HTTP
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list); // instanciar ResponseEntity<T>
	}
}
