package com.sudip.rest.webservices.restfulwebservices.todo;

import com.sudip.rest.webservices.restfulwebservices.todo.repository.TodoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing Todo items using JPA.
 */
@RestController
public class TodoJpaResource {

    private TodoService todoService;
    private TodoRepository todoRepository;

    /**
     * Constructor for TodoJpaResource.
     *
     * @param todoService    The TodoService instance.
     * @param todoRepository The TodoRepository instance.
     */
    public TodoJpaResource(TodoService todoService, TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
        this.todoService = todoService;
    }

    /**
     * Retrieves all Todo items for a specific user.
     *
     * @param username The username of the user whose Todo items are to be retrieved.
     * @return The list of Todo items for the specified user.
     */
    @GetMapping("/users/{username}/todos")
    public List<Todo> retrieveTodos(@PathVariable String username) {
        return todoRepository.findByUsername(username);
    }

    /**
     * Retrieves a specific Todo item for a user.
     *
     * @param username The username of the user.
     * @param id       The ID of the Todo item to retrieve.
     * @return The Todo item with the specified ID for the given user.
     */
    @GetMapping("/users/{username}/todos/{id}")
    public Todo retrieveTodo(@PathVariable String username, @PathVariable int id) {
        return todoRepository.findById(id).get();
    }

    /**
     * Deletes a specific Todo item for a user.
     *
     * @param username The username of the user.
     * @param id       The ID of the Todo item to delete.
     * @return ResponseEntity indicating success (204 No Content) or failure.
     */
    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable int id) {
        todoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Updates a specific Todo item for a user.
     *
     * @param username The username of the user.
     * @param todo     The updated Todo item.
     * @return The updated Todo item.
     */
    @PutMapping("/users/{username}/todos/{id}")
    public Todo updateTodo(@PathVariable String username, @RequestBody Todo todo) {
        todoRepository.save(todo);
        return todo;
    }

    /**
     * Creates a new Todo item for a user.
     *
     * @param username The username of the user.
     * @param todo     The Todo item to create.
     * @return The created Todo item.
     */
    @PostMapping("/users/{username}/todos")
    public Todo createTodo(@PathVariable String username, @RequestBody Todo todo) {
        todo.setUsername(username);
        todo.setId(null);
        return todoRepository.save(todo);
    }
}
