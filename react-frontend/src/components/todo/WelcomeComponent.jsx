import React from 'react'
import { useParams, Link } from 'react-router-dom';

export default function WelcomeComponent() {
    const {username} = useParams();
    return (
      <main className="flex-fill">
        <section className="container py-5">
          <div className="text-center">
            <h1 className="display-4">Welcome,{username}</h1>
            <p className="lead text-muted">
              Manage your tasks efficiently and never miss a deadline.
            </p>
            <Link
              className="btn btn-primary mt-3"
             to="/todos"
            >
              Go to Todos
            </Link>
          </div>
        </section>
      </main>      
    )
}
