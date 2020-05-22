//Arquivo para popular a base de dados (carga inicial da base de dados)

package com.cindyokino.projectmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.cindyokino.projectmongo.domain.Post;
import com.cindyokino.projectmongo.domain.User;
import com.cindyokino.projectmongo.dto.AuthorDTO;
import com.cindyokino.projectmongo.repository.PostRepository;
import com.cindyokino.projectmongo.repository.UserRepository;

@Configuration // para o spring entender que é uma configuracao
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll(); // deletar todos os usuarios e inserir os abaixo:
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));	
			
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Travel", "I'm going to Québec, see you!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Good morning", "I'm so happy today!", new AuthorDTO(maria));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
	}

}
