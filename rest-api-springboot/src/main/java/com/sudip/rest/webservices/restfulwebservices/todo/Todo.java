package com.sudip.rest.webservices.restfulwebservices.todo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.time.LocalDate;

/**
 * Represents a Todo item.
 */
@Entity
public class Todo {

	/**
	 * Default constructor.
	 */
	public Todo() {
	}

	/**
	 * Constructor to initialize Todo object with specified parameters.
	 *
	 * @param id          The unique identifier of the Todo item.
	 * @param username    The username associated with the Todo item.
	 * @param description The description of the Todo item.
	 * @param targetDate  The target date for completing the Todo item.
	 * @param done        Indicates whether the Todo item is completed or not.
	 */
	public Todo(Integer id, String username, String description, LocalDate targetDate, boolean done) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.targetDate = targetDate;
		this.done = done;
	}

	@Id
	@GeneratedValue
	private Integer id;
	private String username;
	private String description;
	private LocalDate targetDate;
	private boolean done;

	/**
	 * Retrieves the unique identifier of the Todo item.
	 *
	 * @return The unique identifier of the Todo item.
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the unique identifier of the Todo item.
	 *
	 * @param id The unique identifier to set.
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Retrieves the username associated with the Todo item.
	 *
	 * @return The username associated with the Todo item.
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the username associated with the Todo item.
	 *
	 * @param username The username to set.
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Retrieves the description of the Todo item.
	 *
	 * @return The description of the Todo item.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description of the Todo item.
	 *
	 * @param description The description to set.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Retrieves the target date for completing the Todo item.
	 *
	 * @return The target date for completing the Todo item.
	 */
	public LocalDate getTargetDate() {
		return targetDate;
	}

	/**
	 * Sets the target date for completing the Todo item.
	 *
	 * @param targetDate The target date to set.
	 */
	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}

	/**
	 * Checks whether the Todo item is completed or not.
	 *
	 * @return True if the Todo item is completed, false otherwise.
	 */
	public boolean isDone() {
		return done;
	}

	/**
	 * Sets the completion status of the Todo item.
	 *
	 * @param done The completion status to set.
	 */
	public void setDone(boolean done) {
		this.done = done;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", username=" + username + ", description=" + description + ", targetDate="
				+ targetDate + ", done=" + done + "]";
	}
}
