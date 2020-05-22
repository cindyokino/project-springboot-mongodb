package com.cindyokino.projectmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cindyokino.projectmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	
	List<Post>findByTitleContainingIgnoreCase(String text); // query method para o Spring Data montar a consulta automaticamente
}
