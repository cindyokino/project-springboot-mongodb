package com.cindyokino.projectmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cindyokino.projectmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

}
