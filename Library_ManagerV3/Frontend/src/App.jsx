import { useState } from 'react'
import User from './User.jsx'
import './App.css'
import {Link, Links, Route, Routes} from "react-router-dom";
import Home from "./Feature/Home.jsx";
import Login from "./Feature/Login.jsx";
import Register from "./Feature/Register.jsx";

function App() {

  return (
    <>

        <nav>
            <Link to = "/">Home</Link>
            <br/>
            <Link to = "/login">Login</Link>
            <br/>
            <Link to="/register">Register</Link>

        </nav>


        <Routes>
            <Route path="/" element={<Home/>}></Route>
            <Route path="/login" element={<Login/>}></Route>
            <Route path="/register" element={<Register/>}></Route>

        </Routes>

      <div>
        <User></User>
      </div>
    </>
  )
}

export default App
