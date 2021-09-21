import axios from "axios";
import { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import { url } from "../common/constants";
import TrainRow from "../components/TrainRow";

const Trains = () => {
  // maintain the state
  const [trains, setTrains] = useState([]);

  // do something automatically
  // []:
  // - accepts a variable and keeps watching the change
  // - when the variable state changes, the function (1st param) gets called
  // - keep the second param empty to execute something when the component gets loaded
  useEffect(() => {
    console.log(`Train Component got loaded`);
    getTrains();
  }, []);

  const getTrains = () => {
    axios.get(url + "/admin/adminpanel/getalltrains").then((response) => {
      const result = response.data;
      console.log("Trains:" + result.data);
      if (result.status === "success") {
        setTrains(result.data);
      } else {
        alert("error while loading list of trains");
      }
    });
  };

  return (
    <div className="form-control">
      <h1 className="page-title">Trains</h1>

      {
        <Link to="/add-train">
          <button className="btn btn-success">Add Train</button>
        </Link>
      }
      <table className="table table-striped">
        <thead>
          <tr>
            <th>Number</th>
            <th>Name</th>
            <th>Type</th>
            <th>Seats Gen</th>
            <th>Seats AC</th>
            <th>Departure at</th>
            <th>Arrival at</th>
            <th>Source Station</th>
            <th>Destination Station</th>
            <th>General Fair</th>
            <th>Ac Fair</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {trains.map((train) => {
            return <TrainRow train={train} />;
          })}
        </tbody>
      </table>
      <img className="img-background-wrapper" src="train.svg" />
    </div>
  );
};

export default Trains;
