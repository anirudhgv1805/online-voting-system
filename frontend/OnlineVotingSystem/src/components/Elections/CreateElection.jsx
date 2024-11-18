/* eslint-disable no-unused-vars */
// src/components/Elections/CreateElection.jsx
import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const CreateElection = () => {
  const [question, setQuestion] = useState('');
  const navigate = useNavigate();

  const handleCreateElection = async (e) => {
    e.preventDefault();
    try {
      await axios.post('http://localhost:8080/api/elections/create', null, {
        params: { question },
      });
      alert('Election created successfully');
      navigate('/dashboard');
    } catch (err) {
      console.error('Error creating election', err);
    }
  };

  return (
    <div>
      <h2>Create Election</h2>
      <form onSubmit={handleCreateElection}>
        <input
          type="text"
          placeholder="Election Question"
          value={question}
          onChange={(e) => setQuestion(e.target.value)}
          required
        />
        <button type="submit">Create Election</button>
      </form>
    </div>
  );
};

export default CreateElection;
