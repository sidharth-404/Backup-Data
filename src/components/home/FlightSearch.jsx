// FlightSearch.js

import React, { useState } from "react";
import FlightResult from "./FlightResult"; // Import the component for displaying search results
import "./Flight.css";
import axios from "axios";
import { ListGroup } from "react-bootstrap";

const FlightSearch = () => {
  // Define state variables for the search form
  const [origin, setOrigin] = useState("");
  const [destination, setDestination] = useState("");
  const [departureDate, setDepartureDate] = useState("");
  const [flightClass, setFlightClass] = useState("");
  const [results, setResults] = useState([]);
  const [suggestionsOrgin, setSuggestionsOrigin] = useState([]);
  const [showSuggestionsOrigin, setShowSuggestionsOrigin] = useState(false);

  const [suggestionsDestination, setSuggestionsDestination] = useState([]);
  const [showSuggestionsDestination, setShowSuggestionsDestination] =
    useState(false);
  const maxSuggestionsToShow = 30;

  const handleInputChange = async (event) => {
    const value = event.target.value;
    setOrigin(value);
    console.log(origin);

    // fetch(`http://localhost:8000/suggest/+${value}`)
    //   .then((response) => response.json())
    //   .then((data) => {
    //     console.log(data);
    //     setSuggestions(data);
    //     // Assuming the API returns an array of suggestions
    //   })
    //   .catch((error) => {
    //     console.error('Error fetching suggestions:', error);
    //   });
    try {
      const test = await axios.get("http://localhost:8000/suggest/" + origin);
      // console.log(test.data);
      setSuggestionsOrigin(test.data);
      setShowSuggestionsOrigin(true);
    } catch (error) {
      console.error("error", error);
    }
  };
  const handleSuggestionClick = (suggestion) => {
    setOrigin(suggestion.code);
    setShowSuggestionsOrigin(false);
  };

  //Destination

  const handleInputDestinationChange = async (event) => {
    const value = event.target.value;
    setDestination(value);
    console.log(destination);

    // fetch(`http://localhost:8000/suggest/+${value}`)
    //   .then((response) => response.json())
    //   .then((data) => {
    //     console.log(data);
    //     setSuggestions(data);
    //     // Assuming the API returns an array of suggestions
    //   })
    //   .catch((error) => {
    //     console.error('Error fetching suggestions:', error);
    //   });
    try {
      const test = await axios.get(
        "http://localhost:8000/suggest/" + destination
      );
      // console.log(test.data);
      setSuggestionsDestination(test.data);
      setShowSuggestionsDestination(true);
    } catch (error) {
      console.error("error", error);
    }
  };

  const handleSuggestionDestinationClick = (suggestion) => {
    setDestination(suggestion.code);
    setShowSuggestionsDestination(false);
  };

  // Function to handle form submission (you can add API calls here)
  const handleSubmit = async () => {
    const mockResult = {
      iataF: origin,
      iataT: destination,
      classType: flightClass,
      date: departureDate,
    };
    console.log(mockResult);

    try {
      // Make the POST request using Axios
      const response = await axios.post(
        "http://localhost:8000/route/airport",
        mockResult
      );

      // Handle the response here (e.g., display a success message)
      console.log("Response:", response.data);
      //console.log(response.data.airLineIata)
      setResults(response.data);
      console.log(results);
    } catch (error) {
      // Handle errors (e.g., display an error message)
      console.error("Error:", error);
    }
    // console.log(mockResults);
    //console.log(results);
    console.log(results);
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
              placeholder="Eg : Hoston"
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
              class=""
              style={{
                backgroundColor: "transparent",
                border: "none",
                borderBottom: "solid 1px",
              }}
              placeholder="destination"
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
              name="flightclass"
              style={{
                backgroundColor: "transparent",
                border: "none",
                borderBottom: "solid 1px",
                width: "200px",
              }}
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
                borderBottom: "solid 1px",
                width: "200px",
              }}
              type="date"
              value={departureDate}
              onChange={(e) => setDepartureDate(e.target.value)}
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
            {suggestionsOrgin
              .slice(0, maxSuggestionsToShow)
              .map((suggestion, index) => (
                <ListGroup.Item
                  key={index}
                  onClick={() => handleSuggestionClick(suggestion)}
                >
                  {suggestion.code} - {suggestion.city}{" "}
                  {/* Display multiple fields */}
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
                onClick={() => handleSuggestionDestinationClick(suggestion)}
              >
                {suggestion.code} - {suggestion.city}{" "}
                {/* Display multiple fields */}
              </ListGroup.Item>
            ))}
        </ListGroup>
        </div>
      )}
      <div
        className="row d-flex align-items-center justify-content-center gap-2"
        style={{ maxHeight: "70vh", overflowY: "scroll" }}
      >
        {results.map((result, index) => (
          <FlightResult key={index} data={result} />
        ))}
      </div>
    </div>
  );
};

export default FlightSearch;
