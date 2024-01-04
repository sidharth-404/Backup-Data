import React, { useState } from "react";

import FlightResult from "./FlightResult"; // Import the component for displaying search results

import "./Flight.css";

import axios from  "axios";

import { ListGroup } from "react-bootstrap";

import FlightResult2 from "./FlightResult2";

const FlightSearchRoundtrip = () => {
  // Define state variables for the search form

  const [origin, setOrigin] = useState("");

  const [destination, setDestination] = useState("");

  const [departureDate, setDepartureDate] = useState("");

  const [returnDate, setReturnDate] = useState(" ");

  const [flightClass, setFlightClass] = useState("");

  const [results, setResults] = useState([]);

  const [results2, setResults2] = useState([]);

  const [suggestionsOrigin, setSuggestionsOrigin] = useState([]); // Separate state for origin suggestions

  const [showSuggestionsOrigin, setShowSuggestionsOrigin] = useState(false); // Separate state for showing origin suggestions

  const [suggestionsDestination, setSuggestionsDestination] = useState([]); // Separate state for destination suggestions

  const [showSuggestionsDestination, setShowSuggestionsDestination] =
    useState(false); // Separate state for showing destination suggestions

  const maxSuggestionsToShow = 20;

  // Handle input change for origin

  const handleInputChange = async (event) => {
    const value = event.target.value;

    setOrigin(value);

    console.log(origin);

    try {
      const test = await axios.get("http://localhost:8000/suggest/" + value);

      console.log(test.data);

      setSuggestionsOrigin(test.data);

      setShowSuggestionsOrigin(true); // Show origin suggestions
    } catch (error) {
      console.error("error", error);
    }
  };

  // Handle suggestion click for origin

  const handleSuggestionClick = (suggestion) => {
    setOrigin(suggestion.code);

    setShowSuggestionsOrigin(false);
  };

  // Handle input change for destination

  const handleInputDestinationChange = async (event) => {
    const value = event.target.value;

    setDestination(value);

    console.log(destination);

    try {
      const test = await axios.get("http://localhost:8000/suggest/" + value);

      console.log(test.data);

      setSuggestionsDestination(test.data);

      setShowSuggestionsDestination(true); // Show destination suggestions
    } catch (error) {
      console.error("error", error);
    }
  };

  // Handle suggestion click for destination

  const handleSuggestionDestinationClick = (suggestion) => {
    setDestination(suggestion.code);

    setShowSuggestionsDestination(false);
  };

  // Function to handle form submission

  const handleSubmit = async () => {
    const startTime = performance.now();

    const mockResult = {
      iataF: origin,

      iataT: destination,

      classType: flightClass,

      date: departureDate,
    };

    const mockResult2 = {
      iataF: destination,

      iataT: origin,

      classType: flightClass,

      date: returnDate,
    };

    try {
      // Make the POST request using Axios

      const response = await axios.post(
        "http://localhost:8000/route/airport",
        mockResult
      );

      const response2 = await axios.post(
        "http://localhost:8000/route/airport",
        mockResult2
      );

      // Handle the response here (e.g., display a success message)

      console.log("Response:", response.data);

      console.log("Response2:", response2.data);

      setResults(response.data);

      setResults2(response2.data);
      const endTime = performance.now();
      const timeElapsed = endTime - startTime;
      console.log("time:", timeElapsed);
    } catch (error) {
      // Handle errors (e.g., display an error message)

      console.error("Error:", error);
    }
  };

  return (
    <div>
      <div
        className="flight-search m-3"
        style={{
          border: "solid 1px",
          padding: "15px",
          borderRadius: "10px",
          display: "flex",
          justifyContent: "center",
        }}
      >
        <div style={{ display: "flex", alignItems: "center", gap: "15px" }}>
          <div
            style={{
              display: "flex",
              flexDirection: "column",
              alignItems: "start",
              backgroundColor: "whitesmoke",
              padding: "10px",
              borderRadius: "5px",
            }}
          >
            <h6>From</h6>
            <input
              type="text"
              class="text_hover_block"
              style={{
                backgroundColor: "transparent",
                border: "none",
                borderBottom: "solid 1px",
              }}
              placeholder="Origin"
              value={origin}
              onChange={handleInputChange}
              onFocus={() => setShowSuggestionsOrigin(true)}
            />
          </div>
          <div>
            <img
              src={"images/right-and-left.png"}
              style={{ width: "30px" }}
              alt=""
            />
          </div>

          <div
            style={{
              display: "flex",
              flexDirection: "column",
              alignItems: "start",
              backgroundColor: "whitesmoke",
              padding: "10px",
              borderRadius: "5px",
            }}
          >
            <h6>To</h6>
            <input 
            type="text"
            class="text_hover_block"
            style={{
              backgroundColor: "transparent",
              border: "none",
              borderBottom: "solid 1px",}}
              type="text"
              class="form-control"
              placeholder="Destination"
              value={destination}
              onChange={handleInputDestinationChange}
              onFocus={() => setShowSuggestionsDestination(true)}
            />

           
          </div>
          <div>
            <img src={"images/seat.png"} style={{ width: "30px" }} alt="" />
          </div>

          <div
            style={{
              display: "flex",
              flexDirection: "column",
              alignItems: "start",
              backgroundColor: "whitesmoke",
              padding: "10px",
              borderRadius: "5px",
            }}
          >
            <h6>Class</h6>
            <select
             style={{
              backgroundColor: "transparent",
              border: "none",
              borderBottom: "solid 1px",}}
              name="flightclass"
              class="form-control"
              value={flightClass}
              onChange={(e) => setFlightClass(e.target.value)}
            >
              <option value="economy">Economy</option>

              <option value="firstClass">FirstClass</option>

              <option value="Bussiness">Bussiness</option>
            </select>
          </div>

          <div>
            <img src={"images/calendar.png"} style={{ width: "30px" }} alt="" />
          </div>
          <div
            style={{
              display: "flex",
              flexDirection: "column",
              alignItems: "start",
              backgroundColor: "whitesmoke",
              padding: "10px",
              borderRadius: "5px",
            }}
          >
            <h6>Depature Date</h6>
            <input
             style={{
              backgroundColor: "transparent",
              border: "none",
              borderBottom: "solid 1px",}}
              type="date"
              value={departureDate}
              onChange={(e) => setDepartureDate(e.target.value)}
            />
          </div>

          <div
            style={{
              display: "flex",
              flexDirection: "column",
              alignItems: "start",
              backgroundColor: "whitesmoke",
              padding: "10px",
              borderRadius: "5px",
            }}
          >
            <h6>Return Date</h6>
            <input
             style={{
              backgroundColor: "transparent",
              border: "none",
              borderBottom: "solid 1px",}}
              type="date"
              value={returnDate}
              onChange={(e) => setReturnDate(e.target.value)}
              placeholder="Return Date"
            />
          </div>

          <div
            class=""
            onClick={() => {
              handleSubmit();
            }}
            className="searchButton"
            style={{
              padding: "18px",
              border: "1px solid",
              borderRadius: "9px",
              cursor: "pointer",
            }}
          >
            <img
              src={"images/search.png"}
              style={{ width: "30px" }}
              alt=""
              className="searchButton"
            />
          </div>
        </div>
      </div>
      
      {showSuggestionsOrigin && (
                <div
                style={{
                  width: "200px",
                  position: "relative",
                  left: "80px",
                  maxHeight: "60vh",
                  overflowY: "scroll",
                  overflowX: "hidden",
                }}
              >
              <ListGroup>
                {suggestionsOrigin
                  .slice(0, maxSuggestionsToShow)
                  .map((suggestion, index) => (
                    <ListGroup.Item
                      key={index}
                      onClick={() => handleSuggestionClick(suggestion)}
                    >
                      {suggestion.code} - {suggestion.city}
                    </ListGroup.Item>
                  ))}
              </ListGroup>
              </div>
            )}
             {showSuggestionsDestination && (
              <div
              style={{
                width: "200px",
                position: "relative",
                left: "345px",
                maxHeight: "60vh",
                overflowY: "scroll",
                overflowX: "hidden",
              }}
            >

              <ListGroup>
                {suggestionsDestination
                  .slice(0, maxSuggestionsToShow)
                  .map((suggestion, index) => (
                    <ListGroup.Item
                      key={index}
                      onClick={() =>
                        handleSuggestionDestinationClick(suggestion)
                      }
                    >
                      {suggestion.code} - {suggestion.city}
                    </ListGroup.Item>
                  ))}
              </ListGroup>
              </div>
            )}
      

      <div
        className="row d-flex align-items-center justify-content-center gap-2"
        style={{ maxHeight: "70vh", overflowY: "scroll" }}
      >
        <FlightResult2 data1={results} data2={results2} />
      </div>
    </div>
  );
};

export default FlightSearchRoundtrip;
