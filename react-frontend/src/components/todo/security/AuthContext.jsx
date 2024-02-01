
import { createContext, useContext, useState } from "react";
import {executeBasicAuthenticationService, executeJwtAuthenticationService} from "../api/AuthenticationApiService"
import { apiClient } from "../api/ApiClient";

//1. Create a Context
export const AuthContext = createContext()

export const useAuth = () => useContext(AuthContext)

//2. Share the created context with other components
export default function AuthProvider({children}){


    //3. Put some state in the conext

    // const [number,setNumber] = useState(10);
    const [isAuthenticated, setAuthenticated] = useState(false);
    const [username, setUsername] = useState(null)
    const [token, setToken] = useState(null)

        // Using jwt authentication
    async function login(username, password){
        
        try {
            const response = await  executeJwtAuthenticationService(username,password)

        if(response.status == 200){
            const jwToken = 'Bearer '+ response.data.token
            setAuthenticated(true)
            setUsername(username)
            setToken(jwToken)

            apiClient.interceptors.request.use(
                (config) =>{
                    console.log('intercepting and adding a token')
                    config.headers.Authorization = jwToken
                    return config
                }
            )

            return true
        } else{
           logout()
            return false
        }
        } catch (error) {
           logout()
            return false
            
        }
    }
    
    function logout(){
        setAuthenticated(false)
        setToken(null)
        setUsername(null)
        return false
    }

    return (
        <AuthContext.Provider value={{isAuthenticated, setAuthenticated,  login, logout, username,token}}>
            {children}
        </AuthContext.Provider>

    )
}