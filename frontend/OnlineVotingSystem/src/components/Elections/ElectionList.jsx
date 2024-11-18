/* eslint-disable no-unused-vars */
/* eslint-disable react/prop-types */
import React, { useState, useEffect } from 'react';
import axios from 'axios';

const ElectionList = () => {
  // State to hold the elections
  const [elections, setElections] = useState([]);

  // Fetch elections from the backend when the component mounts and every 2 seconds
  useEffect(() => {
    const fetchElections = async () => {
      try {
        const response = await axios.get('http://localhost:8080/api/elections/all');
        setElections(response.data);
      } catch (err) {
        console.error('Error fetching elections', err);
      }
    };

    // Fetch elections initially
    fetchElections();

    // Set an interval to fetch elections every 2 seconds
    const interval = setInterval(fetchElections, 2000);

    // Clean up the interval when the component unmounts
    return () => clearInterval(interval);
  }, []);

  // Handle voting
  const handleVote = async (question, voteYes) => {
    try {
      // Send vote to the server
      await axios.post('http://localhost:8080/api/elections/vote', null, {
        params: { question, voteYes },
      });

      // Update vote count locally after voting
      setElections((prevElections) => {
        return prevElections.map((election) => {
          if (election.question === question) {
            return {
              ...election,
              yesVotes: voteYes ? election.yesVotes + 1 : election.yesVotes,
              noVotes: !voteYes ? election.noVotes + 1 : election.noVotes,
            };
          }
          return election;
        });
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
          <div
            key={index}
            style={{
              marginBottom: '20px',
              border: '1px solid #ddd',
              padding: '10px',
            }}
          >
            <p><strong>{election.question}</strong></p>

            {/* Display current vote counts */}
            <div>
              <p>Yes Votes: {election.yesVotes}</p>
              <p>No Votes: {election.noVotes}</p>
            </div>

            {/* Vote buttons */}
            <button
              onClick={() => handleVote(election.question, true)}
              style={{ marginRight: '10px' }}
            >
              Vote Yes
            </button>
            <button onClick={() => handleVote(election.question, false)}>
              Vote No
            </button>
          </div>
        ))
      )}
    </div>
  );
};

export default ElectionList;
