/* eslint-disable no-unused-vars */
/* eslint-disable react/prop-types */
// src/components/Elections/ElectionList.jsx
import React from 'react';
import axios from 'axios';

const ElectionList = ({ elections }) => {
  const handleVote = async (question, voteYes) => {
    try {
      await axios.post('http://localhost:8080/api/elections/vote', null, {
        params: { question, voteYes },
      });
      alert('Vote recorded!');
    } catch (err) {
      console.error('Error voting', err);
    }
  };

  return (
    <div>
      <h3>Available Elections</h3>
      {elections.length === 0 ? (
        <p>No elections available.</p>
      ) : (
        elections.map((election, index) => (
          <div key={index}>
            <p>{election.question}</p>
            <button onClick={() => handleVote(election.question, true)}>Vote Yes</button>
            <button onClick={() => handleVote(election.question, false)}>Vote No</button>
          </div>
        ))
      )}
    </div>
  );
};

export default ElectionList;
