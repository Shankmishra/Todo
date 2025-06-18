package com.Todo.todo.service;

import com.Todo.todo.dto.TodoRequest;
import com.Todo.todo.model.Note;
import com.Todo.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.aggregation.BooleanOperators;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoService {

  private final TodoRepository trepo;

    public void addNote(TodoRequest tr){
     Note note= Note.builder()
                     .notesContent(tr.getNotesContent())
                             .build();
     trepo.save(note);
    }
    public List<Note> viewNotes(){
        List<Note> listnotes = trepo.findAll();
       return listnotes;
    }
    public void deletenote(String noteId){
        trepo.deleteById(noteId);

    }
    public void editnote(String id,TodoRequest todoRequest){
        Note note = trepo.findById(id)
                .orElseThrow(()->new RuntimeException("Note not found"));
        note.setNotesContent(todoRequest.getNotesContent());
        trepo.save(note);
    }

    private TodoRequest mapToNoteResponse(Note note) {
        return TodoRequest.builder()
                .notesContent(note.getNotesContent())
                .build();
    }

}
