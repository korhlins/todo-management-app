package com.collins.todomanagement.service;

import com.collins.todomanagement.dto.TodoDto;

import java.util.List;

public interface TodoService {
    TodoDto addTodo(TodoDto todoDto);

    TodoDto getTodo(Long todoId);

    List<TodoDto> getAllTodo();
}
