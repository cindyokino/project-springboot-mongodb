package com.cindyokino.projectmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.cindyokino.projectmongo.domain.User;
import com.cindyokino.projectmongo.repository.UserRepository;

@Configuration // para o spring entender que é uma configuracao
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll(); // deletar todos os usuarios e inserir os abaixo:
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
	
		userRepository.saveAll(Arrays.asList(maria, alex, bob));	
	}

}
