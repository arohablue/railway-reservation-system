import axios from "axios";
import { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import { url } from "../common/constants";
import TrainRow from "../components/TrainRow";

const SearchedTrains = ({ trains }) => {
  // maintain the state
  const [trainsList, setTrainsList] = useState([]);

  // do something automatically
  // []:
  // - accepts a variable and keeps watching the change
  // - when the variable state changes, the function (1st param) gets called
  // - keep the second param empty to execute something when the component gets loaded
  useEffect(() => {
    console.log(`Train Component got loaded`);
    setTrainsList(trains);
  }, []);

  return (
    <div className="form-control">
      <h1 className="page-title">Book Train</h1>
      <table className="table table-striped">
        <thead>
          <tr>
            <th>Number</th>
            <th>Name</th>
            <th>Type</th>
            <th>Seats Gen</th>
            <th>Seats AC</th>
            <th>Departure Date</th>
            <th>Arrival Date</th>
            <th>Source Station</th>
            <th>Destination Station</th>
            <th>General Fair</th>
            <th>Ac Fair</th>
          </tr>
        </thead>
        <tbody>
          {
            console.log("trains" + trains.data)

            /* {trains.length !== 0 &&
            trains !== undefined &&
            trains.map((train) => {
              return <TrainRow train={train} />;
            })} */
          }
        </tbody>
      </table>
    </div>
  );
};

export default SearchedTrains;
