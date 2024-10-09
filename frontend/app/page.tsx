"use client";

import React, { useState } from 'react';
import axios from 'axios';

function App() {
  const [limit, setLimit] = useState('');
  const [primes, setPrimes] = useState([]);

  const fetchPrimes = async () => {
    try {
      const response = await axios.get(`http://localhost:8080/api/primes?limit=${limit}`);
      setPrimes(response.data);
    } catch (error) {
      console.error("Error fetching primes", error);
    }
  };

  return (
    <div>
      <h1>Prime Number Calculator</h1>
      <input
        type="number"
        value={limit}
        onChange={(e) => setLimit(e.target.value)}
        placeholder="Enter upper limit"
      />
      <button onClick={fetchPrimes}>Calculate Primes</button>
      
      {primes.length > 0 && (
        <div>
          <h2>Prime Numbers:</h2>
          <p>{primes.join(', ')}</p>
        </div>
      )}
    </div>
  );
}

export default App;
