/* eslint-disable no-unused-vars */
// src/components/Dashboard/Dashboard.jsx
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import ElectionList from '../Elections/ElectionList';
import CreateElection from '../Elections/CreateElection';

const Dashboard = () => {
  const [elections, setElections] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    fetchElections();
  }, []);

  const fetchElections = async () => {
    try {
      const response = await axios.get('http://localhost:8080/api/elections/all');
      setElections(response.data);
    } catch (err) {
      console.error('Error fetching elections', err);
    }
  };

  return (
    <div>
      <h2>Dashboard</h2>
      <button onClick={() => navigate('/create-election')}>Create Election</button>
      <ElectionList elections={elections} />
    </div>
  );
};

export default Dashboard;
