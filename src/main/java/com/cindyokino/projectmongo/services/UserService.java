package com.cindyokino.projectmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cindyokino.projectmongo.domain.User;
import com.cindyokino.projectmongo.dto.UserDTO;
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

	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void deleteById(String id) {
		if(!(findById(id)==null)) {
		repo.deleteById(id);
		}
	}
		
	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
		}
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
