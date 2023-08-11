package net.arons.todo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import net.arons.todo.model.Todo;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findTodoByCategoryId(Long categoryId);
}
