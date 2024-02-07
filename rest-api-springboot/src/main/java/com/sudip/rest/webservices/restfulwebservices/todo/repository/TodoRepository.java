package com.sudip.rest.webservices.restfulwebservices.todo.repository;

import com.sudip.rest.webservices.restfulwebservices.todo.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository interface for managing Todo entities.
 */
public interface TodoRepository extends JpaRepository<Todo, Integer> {

    /**
     * Retrieve todos by username.
     *
     * @param username The username to filter todos.
     * @return List of todos belonging to the specified username.
     */
    List<Todo> findByUsername(String username);
}
