/* eslint-disable no-unused-vars */
import React from 'react';
import { Route, Routes } from 'react-router-dom';
import Register from './components/Auth/Register';
import Login from './components/Auth/Login';
import Dashboard from './components/Dashboard/Dashboard';
import CreateElection from './components/Elections/CreateElection';

const App = () =>{
  return (
    <div>
      <Routes>
        <Route path="/register" element={<Register />} />
        <Route path="/login" element={<Login />} />
        <Route path="/dashboard" element={<Dashboard />} />
        <Route path="/create-election" element={<CreateElection />} />
        <Route path="/" element={<Login />} />
      </Routes>
    </div>
  );
};

export default App;
