import axios from "axios";
import { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import { url } from "../common/constants";
import StationRow from "../components/StationRow";

const Station = () => {
  const [stations, setStations] = useState([]);

  useEffect(() => {
    console.log(`Station Component got loaded`);
    getStations();
  }, []);

  const getStations = () => {
    axios.get(url + "/admin/adminpanel/allstations").then((response) => {
      const result = response.data;
      //
      // setUsers(result.data)
      console.log("successful station list created");
      if (result.status === "success") {
        setStations(result.data);
      } else {
        alert("error while loading list of stations");
      }
    });
  };

  return (
    <div className="form-control">
      <h1 className="page-title">Stations</h1>

      <Link to="/add-station">
        <a className="btn btn-success">Add Station</a>
      </Link>
      <table className="table table-striped">
        <thead>
          <tr>
            <th>Station Name</th>
          </tr>
        </thead>
        <tbody>
          {stations.map((station) => {
            return <StationRow station={station} />;
          })}
        </tbody>
      </table>
    </div>
  );
};

export default Station;
