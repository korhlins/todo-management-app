package com.collins.todomanagement.service.impl;

import com.collins.todomanagement.dto.TodoDto;
import com.collins.todomanagement.entity.Todo;
import com.collins.todomanagement.repository.TodoRepository;
import com.collins.todomanagement.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;
    @Override
    public TodoDto addTodo(TodoDto todoDto){
        Todo todo = new Todo();
        BeanUtils.copyProperties(todoDto, todo);

        Todo savedTodo = todoRepository.save(todo);
        TodoDto savedTodoDto = new TodoDto(savedTodo.getId(),
                savedTodo.getTitle(),
                savedTodo.getDescription(),
                savedTodo.isCompleted());
        return savedTodoDto;
    }
}
