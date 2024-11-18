/* eslint-disable no-unused-vars */
// src/components/Auth/Login.jsx
import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const Login = () => {
  const [registerNo, setRegisterNo] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');
  const navigate = useNavigate();

  const handleLogin = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post('http://localhost:8080/api/users/login', null, {
        params: { registerNo, password },
      });
      alert(response.data);
      navigate('/dashboard');
    } catch (err) {
      setError('Login failed, please check your credentials.');
    }
  };

  return (
    <div>
      <h2>Login</h2>
      <form onSubmit={handleLogin}>
        <input
          type="text"
          placeholder="Register No."
          value={registerNo}
          onChange={(e) => setRegisterNo(e.target.value)}
          required
        />
        <input
          type="password"
          placeholder="Password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          required
        />
        {error && <p>{error}</p>}
        <button type="submit">Login</button>
      </form>
      <p>
        Dont have an account? <a href="/register">Register</a>
      </p>
    </div>
  );
};

export default Login;
