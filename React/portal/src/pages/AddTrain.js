import axios from "axios";
import { useEffect, useState } from "react";
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
  const [trainNumber, setTrainNumber] = useState([]);

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
    console.log("add train");
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
      // Date dated = departureTime;
      // let dd = String(dated.getDate()).padStart(2, "0");
      // let mm = String(dated.getMonth() + 1).padStart(2, "0");
      // let hh = String(dated.getHours() + 1).padStart(2, "0");
      // let MM = String(dated.getMinutes() + 1).padStart(2, "0");
      // let yyyy = dated.getFullYear();

      // Date datea = departureTime;
      // let dd1 = String(datea.getDate()).padStart(2, "0");
      // let mm1 = String(datea.getMonth() + 1).padStart(2, "0");
      // let hh1 = String(datea.getHours() + 1).padStart(2, "0");
      // let MM1 = String(datea.getMinutes() + 1).padStart(2, "0");
      // let yyyy1 = datea.getFullYear();

      // let departureDate = yyyy1 + "-" + mm1 + "-" + dd1 + " " + hh1 + ":" + MM1;
      // let arrivalDate = yyyy + "-" + mm + "-" + dd + " " + hh + ":" + MM;

      let departureDate = departureTime.split("T").join(" ");
      let arrivalDate = arrivalTime.split("T").join(" ");

      console.log();
      const data = {
        trainName: trainName,
        trainType: trainType,
        trainNumber: trainNumber,
        noOfSeatsGen: noOfSeatsGen,
        noOfSeatsAC: noOfSeatsAC,
        departureTime: departureDate,
        arrivalTime: arrivalDate,
        route: { routeId: routeId },
      };
      console.log(data);

      // send the album info to the API
      axios.post(url + "/admin/adminpanel/addtrain", data).then((response) => {
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
    <div className="add-train-wrapper">
      <h1 className="page-title">Add Train</h1>
      <div className="mb-3">
        <label className="label-bold" htmlFor="">
          Name
        </label>
        <input
          onChange={(e) => {
            setTrainName(e.target.value);
          }}
          type="text"
          className="form-control"
        />
      </div>
      <div className="mb-3">
        <label className="label-bold" htmlFor="">
          Number
        </label>
        <input
          onChange={(e) => {
            setTrainNumber(e.target.value);
          }}
          type="number"
          className="form-control"
        />
      </div>
      <div className="mb-3">
        <label className="label-bold">Type :</label>
        <select
          name="type"
          id="type"
          onChange={(event) => {
            setTrainType(event.target.value);
          }}
        >
          <option value="">None</option>
          <option value="Express">Express</option>
          <option value="Tejas Express">Tejas Express</option>
          <option value="Superfast Express">Superfast Express</option>
          <option value="Passenger">Passenger</option>
          <option value="Mail">Mail</option>
          <option value="Intercity Express">Intercity Express</option>
          <option value="AC Express">AC Express</option>
        </select>
      </div>
      <div className="mb-3">
        <label className="label-bold" htmlFor="">
          No of Seats in General Class
        </label>
        <input
          onChange={(e) => {
            setNoOfSeatsGen(e.target.value);
          }}
          type="number"
          className="form-control"
        />
      </div>
      <div className="mb-3">
        <label className="label-bold" htmlFor="">
          No of Seats in AC Class
        </label>
        <input
          onChange={(e) => {
            setNoOfSeatsAC(e.target.value);
          }}
          type="number"
          className="form-control"
        />
      </div>
      <div className="mb-3">
        <label className="label-bold" htmlFor="">
          Departure Time
        </label>
        <input
          onChange={(e) => {
            setDepartureTime(e.target.value);
          }}
          type="datetime-local"
          className="form-control"
        />
      </div>
      <div className="mb-3">
        <label className="label-bold" htmlFor="">
          Arrival Time
        </label>
        <input
          onChange={(e) => {
            setArrivalTime(e.target.value);
          }}
          type="datetime-local"
          className="form-control"
        />
      </div>
      <div className="mb-3">
        <label className="label-bold" htmlFor="">
          Route of Train
        </label>
        <select
          value={routeId}
          onChange={handleRouteChange}
          className="form-control"
        >
          <option value="">Select Route</option>;
          {routes.map((route) => {
            return (
              <option value={route.routeId}>
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
      <img src="train.svg" />
    </div>
  );
};

export default AddTrain;
