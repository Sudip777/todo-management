package com.sudip.rest.webservices.restfulwebservices.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

/**
 * Service class to manage Todo objects.
 */
@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<>();
	private static int todosCount = 0;

	// Populate initial todos
	static {
		todos.add(new Todo(++todosCount, "sudip", "Get AWS Certified Now", LocalDate.now().plusYears(10), false));
		todos.add(new Todo(++todosCount, "sudip", "Learn DevOps", LocalDate.now().plusYears(11), false));
		todos.add(new Todo(++todosCount, "sudip", "Learn Full Stack Development", LocalDate.now().plusYears(12), false));
	}

	/**
	 * Retrieve todos by username.
	 *
	 * @param username The username to filter todos.
	 * @return List of todos belonging to the specified username.
	 */
	public List<Todo> findByUsername(String username) {
		Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}

	/**
	 * Add a new todo.
	 *
	 * @param username     The username of the todo owner.
	 * @param description  The description of the todo.
	 * @param targetDate   The target date for completion.
	 * @param done         Whether the todo is completed.
	 * @return The newly added todo.
	 */
	public Todo addTodo(String username, String description, LocalDate targetDate, boolean done) {
		Todo todo = new Todo(++todosCount, username, description, targetDate, done);
		todos.add(todo);
		return todo;
	}

	/**
	 * Delete a todo by its ID.
	 *
	 * @param id The ID of the todo to delete.
	 */
	public void deleteById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}

	/**
	 * Find a todo by its ID.
	 *
	 * @param id The ID of the todo to find.
	 * @return The todo object if found, otherwise null.
	 */
	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		return todos.stream().filter(predicate).findFirst().orElse(null);
	}

	/**
	 * Update a todo.
	 *
	 * @param todo The todo object with updated information.
	 */
	public void updateTodo(Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
	}
}
