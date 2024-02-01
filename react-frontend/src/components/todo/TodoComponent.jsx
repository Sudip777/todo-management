import React, { useEffect, useState } from 'react'
import {  useParams } from 'react-router-dom'
import { retrieveTodoApi, updateTodoApi } from './api/TodoApiService'
import { useAuth } from './security/AuthContext'
import { ErrorMessage, Field, Form, Formik } from 'formik'
import { useNavigate } from 'react-router-dom'

export default function TodoComponent() {

  const {id} = useParams()
  const authContext = useAuth()
  const navigate = useNavigate()
  const username = authContext.username

  const [description, setDescription] = useState('')
  const [targetDate, setTargetDate] = useState('')

  useEffect(()=> retrieveTodos(),[id])


  function retrieveTodos(){

    if(id!= -1){

      retrieveTodoApi(username, id)
      .then( response => {
        setDescription(response.data.description)
        setTargetDate(response.data.targetDate)
      })
  
      .catch(error => console.log(error))
    }
  }

  function onSubmit(values){
    const todo = {
      id :id,
      username: username,
      description:values.description,
      targetDate: values.targetDate,
      done:false

    }
    console.log(todo)
    // console.log(values)
    updateTodoApi(username, id, todo)
    .then( response => {
     navigate('/todos')
    })

    .catch(error => console.log(error))
  }

  function validate(values){
    let errors = {
      // description:'Enter a valid description',
      // targetDate:'Enter a valid target date'
    }

    if(values.description.length <5){
      errors.description = 'Enter at least 5 characters'
    }

    if(values.targetDate == null || values.targetDate==''){
      errors.targetDate = 'Enter a target date'
    }
    
   return errors
  }

  return (
    <div className='container'>
        <h1>Enter Todo Details</h1>
        <div>
          <Formik 
          initialValues={{description,targetDate}}
          enableReinitialize={true}
          onSubmit={onSubmit}
          validate={validate}
          validateOnChange={false}
          validateOnBlur={false}
          >
            {
              (props) =>(
              
              <Form>
                <ErrorMessage
                name='description'
                component="div"
                className="alert alert-warning"
                />

                <ErrorMessage
                name='targetDate'
                component="div"
                className="alert alert-warning"
                />

                <fieldset className='form-group'>
                  <label>Description</label>
                  <Field className="form-control" name="description"/>
                </fieldset>

                <fieldset className='form-group'>
                  <label>Target Date</label>
                  <Field type="date" className="form-control" name="targetDate"/>
                </fieldset>
                <div>
                  <button type="submit"  className='btn btn-success m-5'>Save</button>
                </div>
              </Form> 
              )              
            }
          </Formik>
        </div>
    </div>
  )
}
