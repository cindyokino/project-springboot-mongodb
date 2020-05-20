package com.cindyokino.projectmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cindyokino.projectmongo.domain.User;
import com.cindyokino.projectmongo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired // mecanismo de injecao automatica do Spring
	private UserRepository repo; // quando declaro um objeto dentro de uma classe usando @Autowired, o Spring instancia para mim  

	public List<User> findAll() {
		return repo.findAll();
	}

}
