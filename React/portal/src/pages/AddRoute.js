import axios from "axios";
import { useState, useEffect, useCallback } from "react";
import { Link, useHistory } from "react-router-dom";
import { url } from "../common/constants";

const AddRoute = () => {
  const [sourceStation, setSourceStation] = useState("");
  const [destinationStation, setDestinationStation] = useState("");
  const [genFair, setGenFair] = useState("");
  const [acFair, setACfair] = useState("");

  const [stations, setStations] = useState([]);

  useEffect(() => {
    getStations();
  }, []);

  const getStations = useCallback(() => {
    axios.get(url + "/admin/adminpanel/getallstation").then((response) => {
      const result = response.data;
      if (result.status === "success") {
        if (result.data.length > 0) {
          // select the first artist from the list
          // select the default artist
          setStations(result.data);
        }
      } else {
        alert("error while loading list of Train");
      }
    });
  }, [setStations]);

  const history = useHistory();

  // useEffect(() => {
  //   getRoutes()
  // }, [])

  // const getRoutes = () => {
  //   axios.get(url + '/admin/adminpanel/route').then((response) => {
  //     const result = response.data
  //     if (result.status === 'success') {
  //       if (result.data.length > 0) {
  //         // select the first artist from the list
  //         // select the default artist
  //         // setRoute(result.data[0].id)
  //         setRoutes(result.data)
  //       }
  //     } else {
  //       alert('error while loading list of routes')
  //     }
  //   })
  // }

  const addRoute = () => {
    if (sourceStation.length === 0) {
      alert("enter Source");
    } else if (destinationStation.length === 0) {
      alert("enter destination");
    } else if (genFair.length === 0) {
      alert("enter Gen Fair");
    } else if (acFair.length === 0) {
      alert("enter AC fair");
    } else if (sourceStation === destinationStation) {
      alert("Source and Destination cannot be same");
    } else {
      //const data = new FormData();
      console.log(stations);
      const data = {
        acClassFair: acFair,
        generalClassFair: genFair,
        sourceStation: { stationId: sourceStation },
        destinationStation: { stationId: destinationStation },
      };

      console.log(data);

      // send the album info to the API
      axios.post(url + "/admin/adminpanel/addroute", data).then((response) => {
        const result = response.data;
        if (result.status === "success") {
          alert("successfully added new Route");
          history.push("/routes");
        } else {
          console.log(result.error);
          alert("error while loading Routes");
        }
      });
    }
  };

  function handleSourceChange(event) {
    console.log("change Value " + event.target.value);
    setSourceStation(event.target.value);
  }

  function handleDestinationChange(event) {
    setDestinationStation(event.target.value);
  }

  return (
    <div>
      <h1 className="page-title">Add Route</h1>
      <div className="mb-3 add-train-wrapper">
        <label className="label-bold" htmlFor="">
          Source
        </label>
        <select
          value={sourceStation}
          onChange={handleSourceChange}
          className="form-control"
        >
          <option value="">Select Source</option>;
          {stations.map((station) => {
            return (
              <option value={station.stationId}>{station.stationName}</option>
            );
          })}
        </select>
      </div>

      <div className="mb-3 add-train-wrapper">
        <label className="label-bold" htmlFor="">
          Destination
        </label>
        <select
          value={destinationStation}
          onChange={handleDestinationChange}
          className="form-control"
        >
          <option value="">Select Destination</option>;
          {stations.map((station) => {
            return (
              <option value={station.stationId}>{station.stationName}</option>
            );
          })}
        </select>
      </div>
      <div className="mb-3 add-train-wrapper">
        <label className="label-bold" htmlFor="">
          General Fair
        </label>
        <input
          onChange={(e) => {
            setGenFair(e.target.value);
          }}
          type="number"
          className="form-control"
        />
      </div>
      <div className="mb-3 add-train-wrapper">
        <label className="label-bold" htmlFor="">
          AC Fair
        </label>
        <input
          onChange={(e) => {
            setACfair(e.target.value);
          }}
          type="number"
          className="form-control"
        />
      </div>
      <div className="mb-3 add-train-wrapper">
        <button onClick={addRoute} className="btn btn-success">
          Add
        </button>

        <Link to="/routes">
          <a className="btn btn-warning">Back</a>
        </Link>
      </div>
      <img src="routes.svg" />
    </div>
  );
};

export default AddRoute;
