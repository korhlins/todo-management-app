package com.collins.todomanagement.utils;

import com.collins.todomanagement.dto.TodoDto;
import com.collins.todomanagement.entity.Todo;

public class Mapper {
    public static Todo toTodo(TodoDto todoDto){
        Todo todo = new Todo();
        todo.setTitle(todoDto.title());
        todo.setDescription(todoDto.description());
        todo.setCompleted(todoDto.isCompleted());
        return todo;
    }

    public static TodoDto todoDto(Todo todo){
        return new TodoDto(
                todo.getId(),
                todo.getTitle(),
                todo.getDescription(),
                todo.isCompleted()
        );
    }
}
