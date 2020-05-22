package com.cindyokino.projectmongo.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cindyokino.projectmongo.domain.Post;
import com.cindyokino.projectmongo.resources.util.URL;
import com.cindyokino.projectmongo.services.PostService;

@RestController // indica que a classe é um recurso REST
@RequestMapping(value="/posts") // indica qual o caminho do endpoint
public class PostResource {
	
	@Autowired
	private PostService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET) // indica que o método vai ser o endpoint REST no caminho /users
	public ResponseEntity<Post> findById(@PathVariable String id) { // ResponseEntity<T> encapsula para retornar respostas HTTP
		Post obj = service.findById(id);		
		return ResponseEntity.ok().body(obj); // instanciar ResponseEntity<T>
	}
	
	@RequestMapping(value="/titlesearch", method=RequestMethod.GET)
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue="") String text) { 
		text = URL.decodeParam(text); // decodifica text
		List<Post> list = service.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}	
	
	@RequestMapping(value="/fullsearch", method=RequestMethod.GET)
	public ResponseEntity<List<Post>> fullSearch(
			@RequestParam(value="text", defaultValue="") String text,
			@RequestParam(value="minDate", defaultValue="") String minDate,
			@RequestParam(value="maxDate", defaultValue="") String maxDate) { 		
		text = URL.decodeParam(text); // decodifica text
		Date min = URL.convertDate(minDate, new Date(0L)); // se minDate nao funcionar, tem essa data padrao 01/01/1970
		Date max = URL.convertDate(maxDate, new Date()); // se minDate nao funcionar, tem essa data padrao 01/01/1970vou pegar a data do sistema neste momento
		List<Post> list = service.fullSearch(text, min, max);
		return ResponseEntity.ok().body(list);
	}	
}
