import React, { useEffect, useState } from "react";
import {
  deleteTodoApi,
  retrieveAllTodosForUsernameApi,
} from "./api/TodoApiService";
import { useAuth } from "./security/AuthContext";
import { useNavigate } from "react-router-dom";

export default function ListTodosComponent() {
  // const today = new Date();
  const authContext = useAuth()
  const username = authContext.username;
  const navigate = useNavigate()


  // const targetDate = new Date(
  //   today.getFullYear() + 12,
  //   today.getMonth(),
  //   today.getDay()
  // );

  const [todos, setTodos] = useState([]);
  const [message, setMessage] = useState(null);

  // const todos=[
  //   // {id:1, description:"Learn AWS", done:false, targetDate:targetDate},
  //   // {id:2, description:"Learn DevOps", done:false, targetDate:targetDate},
  //   // {id:3, description:"Learn Full Stack Development", done:false, targetDate:targetDate}
  // ]

  useEffect(() => refreshTodos(), []);

  function refreshTodos() {
    retrieveAllTodosForUsernameApi(username)
      .then((response) => {
        console.log(response);
        setTodos(response.data);
      })

      .catch((error) => console.log(error));
  }

  function deleteTodo(id) {
    console.log("delete is called" + id);
    deleteTodoApi(username, id)
      .then(
        () => {
          setMessage(`Delete of todo with id = ${id} Successful`);
        }
        //1. Display Message
        // 2. Update todo List
      )
      .catch((error) => console.log(error));
      
  }

  function updateTodo(id) {
    console.log("Update clicked" + id);
    navigate(`/todo/${id}`)

  
  }

  function addNewTodo(id) {
    console.log("Update clicked" + id);
    navigate(`/todo/-1`)

  
  }

  return (
    <div className="container my-5">
  <h1 className="text-center mb-4">Things you like to try?</h1>
  {message && <div className="alert alert-warning">{message}</div>}
  <div className="table-responsive">
    <table className="table table-bordered table-hover">
      <thead className="table-light">
        <tr>
          <th scope="col">Description</th>
          <th scope="col">Is Done?</th>
          <th scope="col">Target Date</th>
          <th scope="col">Actions</th>
        </tr>
      </thead>
      <tbody>
        {todos.map((todo) => (
          <tr key={todo.id}>
            <td>{todo.description}</td>
            <td>{todo.done.toString()}</td>
            <td>{todo.targetDate.toString()}</td>
            <td>
              <button
                className="btn btn-sm btn-outline-warning"
                onClick={() => deleteTodo(todo.id)}
              >
                Delete
              </button>
              <button
                className="btn btn-sm btn-outline-success ms-2"
                onClick={() => updateTodo(todo.id)}
              >
                Update
              </button>
            </td>
          </tr>
        ))}
      </tbody>
    </table>
  </div>
  <div className="d-grid gap-2">
    <button className="btn btn-lg btn-primary" onClick={addNewTodo}>
      Add New Todo
    </button>
  </div>
</div>
  );
}
