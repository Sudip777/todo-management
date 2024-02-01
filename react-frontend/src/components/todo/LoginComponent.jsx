import React from "react";
import { useState } from "react";
import { useAuth } from "./security/AuthContext";
import { useNavigate } from "react-router-dom";

export default function LoginComponent() {
  const [username, setUsername] = useState("sudip");
  const [password, setPassword] = useState("");
  const [showErrorMessage, setShowErrorMessage] = useState(false);

  const navigate = useNavigate();
  const authContext = useAuth();

  function usernameHandler(e) {
    setUsername(e.target.value);
  }

  function passwordHandler(e) {
    setPassword(e.target.value);
  }

  async function handleSubmit() {
    if (await authContext.login(username, password)) {
      navigate(`/welcome/${username}`);
    } else {
      setShowErrorMessage(true);
    }
  }

  return (
    <div className="container">
      <div className="row justify-content-center">
        <div className="col-md-6">
          <form className="Login">
            <h1 className="mb-4"> Login</h1>

            {showErrorMessage && (
              <div className="alert alert-danger" role="alert">
                Authentication Failed!!! Try again
              </div>
            )}

            <div className="mb-4">
              <label htmlFor="form1Example1" className="form-label">
              username
              </label>
              <input
                type="text"
                id="form1Example1"
                className="form-control"
                name="name"
                value={username}
                onChange={usernameHandler}
              />
            </div>

            <div className="mb-4">
              <label htmlFor="form1Example2" className="form-label">
                Password
              </label>
              <input
                type="password"
                id="form1Example2"
                className="form-control"
                name="password"
                value={password}
                onChange={passwordHandler}
              />
            </div>

            <div className="row mb-4">
              <div className="col d-flex justify-content-center">
                <div className="form-check">
                  <input
                    className="form-check-input"
                    type="checkbox"
                    value=""
                    id="form1Example3"
                    checked
                  />
                  <label className="form-check-label" htmlFor="form1Example3">
                    Remember me
                  </label>
                </div>
              </div>

              <div className="col">
                <a href="#!" className="text-decoration-none">
                  Forgot password?
                </a>
              </div>
            </div>

            <button
              type="button"
              className="btn btn-primary btn-block"
              name="login"
              onClick={handleSubmit}
            >
              Login
            </button>
          </form>
        </div>
      </div>
    </div>
  );
}
