import axios from "axios";
import { useState, useEffect } from "react";
import { Link, useHistory } from "react-router-dom";
import { url } from "../common/constants";

const AddTrain = () => {
  const [routeId, setRouteId] = useState("");
  const [trainName, setTrainName] = useState("");
  const [trainType, setTrainType] = useState("");
  const [noOfSeatsGen, setNoOfSeatsGen] = useState("");
  const [noOfSeatsAC, setNoOfSeatsAC] = useState("");
  const [departureTime, setDepartureTime] = useState("");
  const [arrivalTime, setArrivalTime] = useState("");
  const [routes, setRoutes] = useState([]);

  const history = useHistory();

  useEffect(() => {
    getRoutes();
  }, []);

  const getRoutes = () => {
    axios.get(url + "/admin/adminpanel/getallroutes").then((response) => {
      const result = response.data;
      if (result.status === "success") {
        if (result.data.length > 0) {
          // select the first artist from the list
          // select the default artist
          setRoutes(result.data);
        }
      } else {
        alert("error while loading list of Train");
      }
    });
  };

  const addTrain = () => {
    if (trainName.length === 0) {
      alert("enter Train Name");
    } else if (trainType.length === 0) {
      alert("enter Train type");
    } else if (noOfSeatsGen.length === 0) {
      alert("Enter No Of Seats Gen");
    } else if (noOfSeatsAC.length === 0) {
      alert("enter No Of Seats AC");
    } else if (departureTime.length === 0) {
      alert("enter Departure time");
    } else if (arrivalTime.length === 0) {
      alert("enter Arrival time");
    } else if (routeId.length === 0) {
      alert("enter Route");
    } else {
      const data = {
        trainName: trainName,
        trainType: trainType,
        noOfSeatsGen: noOfSeatsGen,
        noOfSeatsAC: noOfSeatsAC,
        departureTime: departureTime,
        arrivalTime: arrivalTime,
        route: { routeId: routeId },
      };

      // send the album info to the API
      axios.post(url + "/admin/adminpanel/train", data).then((response) => {
        const result = response.data;
        if (result.status === "success") {
          alert("successfully added new Train");
          history.push("/train");
        } else {
          console.log(result.error);
          alert("error while loading Train");
        }
      });
    }
  };

  function handleRouteChange(event) {
    setRouteId(event.target.value);
  }

  return (
    <div>
      <h1 className="page-title">Add Train</h1>
      <div className="mb-3">
        <label htmlFor="">Name</label>
        <input
          onChange={(e) => {
            setTrainName(e.target.value);
          }}
          type="text"
          className="form-control"
        />
      </div>
      <div className="mb-3">
        <label htmlFor="">TrainType</label>
        <input
          onChange={(e) => {
            setTrainType(e.target.value);
          }}
          type="text"
          className="form-control"
        />
      </div>
      <div className="mb-3">
        <label htmlFor="">ClassGen</label>
        <input
          onChange={(e) => {
            setNoOfSeatsGen(e.target.value);
          }}
          type="text"
          className="form-control"
        />
      </div>
      <div className="mb-3">
        <label htmlFor="">ClassAC</label>
        <input
          onChange={(e) => {
            setNoOfSeatsAC(e.target.value);
          }}
          type="text"
          className="form-control"
        />
      </div>
      <div className="mb-3">
        <label htmlFor="">Departure Time</label>
        <input
          onChange={(e) => {
            setDepartureTime(e.target.value);
          }}
          type="text"
          className="form-control"
        />
      </div>
      <div className="mb-3">
        <label htmlFor="">Arrival Time</label>
        <input
          onChange={(e) => {
            setArrivalTime(e.target.value);
          }}
          type="text"
          className="form-control"
        />
      </div>
      <div className="mb-3">
        <label htmlFor="">Destination</label>
        <select
          value={routeId}
          onChange={handleRouteChange}
          className="form-control"
        >
          <option value="">Select Route</option>;
          {routes.map((route) => {
            return (
              <option value={route.id}>
                {route.sourceStation.stationName}-
                {route.destinationStation.stationName}
              </option>
            );
          })}
        </select>
      </div>

      <div className="mb-3">
        <button onClick={addTrain} className="btn btn-success">
          Add
        </button>

        <Link to="/train">
          <a className="btn btn-warning">Back</a>
        </Link>
      </div>
    </div>
  );
};

export default AddTrain;
