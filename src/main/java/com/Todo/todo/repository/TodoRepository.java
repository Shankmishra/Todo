package com.Todo.todo.repository;

import com.Todo.todo.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends MongoRepository<Note,String> {

}
