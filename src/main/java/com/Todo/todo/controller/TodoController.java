package com.Todo.todo.controller;

import com.Todo.todo.dto.TodoRequest;
import com.Todo.todo.model.Note;
import com.Todo.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/root/todo")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addNote(@RequestBody TodoRequest tq){
        todoService.addNote(tq);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Note> viewAll(){
       return todoService.viewNotes();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteNote(@PathVariable String id){
      todoService.deletenote(id);
    }

}
