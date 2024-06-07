package com.collins.todomanagement.service.impl;

import com.collins.todomanagement.dto.TodoDto;
import com.collins.todomanagement.entity.Todo;
import com.collins.todomanagement.exception.ResourceNotFoundException;
import com.collins.todomanagement.repository.TodoRepository;
import com.collins.todomanagement.service.TodoService;
import com.collins.todomanagement.utils.Mapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.collins.todomanagement.utils.Mapper.toTodo;

@AllArgsConstructor
@Service
public class TodoServiceImpl implements TodoService {

    private ModelMapper modelMapper;

    private TodoRepository todoRepository;
    @Override
    public TodoDto addTodo(TodoDto todoDto){

       Todo todo = toTodo(todoDto);
       Todo savedTodo = todoRepository.save(todo);

       return Mapper.todoDto(savedTodo);
    }

    @Override
    public TodoDto getTodo(Long todoId){
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new ResourceNotFoundException("Todo not found with id:" + todoId));
        return Mapper.todoDto(todo);
    }

    @Override
    public List<TodoDto> getAllTodo(){
        return todoRepository.findAll().stream().map(Mapper::todoDto).collect(Collectors.toList());
    }

    @Override
    public TodoDto updateTodo(TodoDto todoDto, Long todoId){
        TodoDto retrievedTodoDto = getTodo(todoId);

        Todo retrievedTodo = Mapper.toTodo(retrievedTodoDto);

        retrievedTodo.setTitle(todoDto.title());
        retrievedTodo.setDescription(todoDto.description());
        retrievedTodo.setCompleted(todoDto.isCompleted());

        System.out.println(retrievedTodo.getDescription());
        return Mapper.todoDto(todoRepository.save(retrievedTodo));
    }

    @Override
    public void deleteTodo(Long todoId){
         getTodo(todoId);
         todoRepository.deleteById(todoId);
    }

    @Override
    public TodoDto completeTodo(Long todoId){
        TodoDto todoDto = getTodo(todoId);

        Todo todo = Mapper.toTodo(todoDto);
        todo.setCompleted(Boolean.TRUE);

        return Mapper.todoDto(todoRepository.save(todo));
    }

    @Override
    public TodoDto inCompleteTodo(Long todoId){
        TodoDto todoDto = getTodo(todoId);

        Todo todo = Mapper.toTodo(todoDto);
        todo.setCompleted(Boolean.FALSE);

        return Mapper.todoDto(todoRepository.save(todo));
    }
}
