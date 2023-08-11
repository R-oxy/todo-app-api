package net.arons.todo.services;

import java.util.List;

import net.arons.todo.dto.TodoDto;

public interface TodoService {

    TodoDto save(TodoDto todoDto);

    List<TodoDto> findAll();

    TodoDto findById(Long id);

    List<TodoDto> findByCategory(Long categoryId);

    void delete(Long id);

}
