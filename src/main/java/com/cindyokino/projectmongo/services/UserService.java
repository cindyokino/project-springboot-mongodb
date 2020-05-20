package com.cindyokino.projectmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cindyokino.projectmongo.domain.User;
import com.cindyokino.projectmongo.repository.UserRepository;
import com.cindyokino.projectmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired // mecanismo de injecao automatica do Spring
	private UserRepository repo; // quando declaro um objeto dentro de uma classe usando @Autowired, o Spring instancia para mim  

	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}

}
