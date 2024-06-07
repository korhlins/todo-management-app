package com.collins.todomanagement.controller;

import com.collins.todomanagement.dto.TodoDto;
import com.collins.todomanagement.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/todos")
public class TodoController {

    private TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto todoDto){
        TodoDto savedDto = todoService.addTodo(todoDto);
        return new ResponseEntity<>(savedDto, HttpStatus.CREATED);
    }

    @GetMapping("{Id}")
    public ResponseEntity<TodoDto> getTodo(@PathVariable("Id") Long todoId){
        TodoDto retrievedTodo = todoService.getTodo(todoId);
        return ResponseEntity.ok(retrievedTodo);
    }

    @GetMapping
    public ResponseEntity<List<TodoDto>> getAllTodo(){
       List<TodoDto> todoDto = todoService.getAllTodo();
       return ResponseEntity.ok(todoDto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TodoDto> updateTodo(@RequestBody TodoDto todoDto, @PathVariable("id") Long todoId){
        TodoDto updatedTodo = todoService.updateTodo(todoDto, todoId);
        return ResponseEntity.ok(updatedTodo);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Long todoId){
        todoService.deleteTodo(todoId);
        return ResponseEntity.ok("Todo Successfully deleted!");
    }

    @PatchMapping("{id}/complete")
    public ResponseEntity<TodoDto> completeTodo(@PathVariable("id") Long todoId){
         TodoDto todoDto = todoService.completeTodo(todoId);
         return ResponseEntity.ok(todoDto);
    }

    @PatchMapping("{id}/in-complete")
    public ResponseEntity<TodoDto> inCompleteTodo(@PathVariable("id") Long todoId){
        TodoDto todoDto = todoService.inCompleteTodo(todoId);
        return ResponseEntity.ok(todoDto);
    }
}
