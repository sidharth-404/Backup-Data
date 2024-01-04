// FlightResult.js

import React from 'react';


function FlightResult({ data }) {
  //let myImage='https://source.unsplash.com/random/200x200?sig=1'
  return (
    <div className="card col-3 m-2">
          <div className="card-body d-flex align-items-center" style={{height:"80px"}}>
           <div className="d-flex align-items-center justify-content-evenly gap-2">
             <img src={'images/airplane.png'} alt="" style={{width:"30px"}} />
             <h6  style={{fontSize:"16px", fontStyle:"bold"}}>{data.airline.name}</h6>
             <div className="d-flex align-items-center justify-content-center gap-2">
             <img src={'images/clock.png'} alt="" style={{width:"15px"}} className="mb-2" />
             <h6 style={{fontSize:"14px"}}>{Number(data.routes.min_duration) < Number(data. routes.max_duration) ? `${data.routes.min_duration} - ${data.routes.max_duration} Mins` :`${data.routes.max_duration} Mins`}</h6>
             </div>
           </div>
      </div>
    </div>
  );


}

export default FlightResult;
