// FlightResult.js

import React from "react";

function FlightResult2({ data1, data2 }) {
  //let myImage='https://source.unsplash.com/random/200x200?sig=1'
  return (
    <div
      style={{
        display: "flex",
        gap: "20px",
        alignItems: "center",
        justifyContent: "center",
      }}
    >
      <div>
        <h6>Departure Airline</h6>
        {data1.map((data, index) => (
          <div className="card mb-2">
            <div
              className="card-body d-flex align-items-center"
              style={{ height: "80px" }}
              key={index}
            >
              <div className="d-flex align-items-center justify-content-evenly gap-2">
                <img
                  src={"images/airplane.png"}
                  alt=""
                  style={{ width: "30px" }}
                />
                <h6 style={{ fontSize: "16px", fontStyle: "bold" }}>
                  {data.airline.name}
                </h6>
                <div className="d-flex align-items-center justify-content-center gap-2">
                  <img
                    src={"images/clock.png"}
                    alt=""
                    style={{ width: "15px" }}
                    className="mb-2"
                  />
                  <h6 style={{ fontSize: "14px" }}>
                    {Number(data.routes.min_duration) <
                    Number(data.routes.max_duration)
                      ? `${data.routes.min_duration} - ${data.routes.max_duration} Mins`
                      : `${data.routes.max_duration} Mins`}
                  </h6>
                </div>
              </div>
            </div>
          </div>
        ))}
      </div>
      <div>
        <h6>Return Airline</h6>
        {data2.map((data, index) => (
          <div className="card mb-2">
            <div
              className="card-body d-flex align-items-center"
              style={{ height: "80px" }}
              key={index}
            >
              <div className="d-flex align-items-center justify-content-evenly gap-2">
                <img
                  src={"images/airplane.png"}
                  alt=""
                  style={{ width: "30px" }}
                />
                <h6 style={{ fontSize: "16px", fontStyle: "bold" }}>
                  {data.airline.name}
                </h6>
                <div className="d-flex align-items-center justify-content-center gap-2">
                  <img
                    src={"images/clock.png"}
                    alt=""
                    style={{ width: "15px" }}
                    className="mb-2"
                  />
                  <h6 style={{ fontSize: "14px" }}>
                    {Number(data.routes.min_duration) <
                    Number(data.routes.max_duration)
                      ? `${data.routes.min_duration} - ${data.routes.max_duration} Mins`
                      : `${data.routes.max_duration} Mins`}
                  </h6>
                </div>
              </div>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}

export default FlightResult2;
