import axios from "axios";
import { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import { url } from "../common/constants";
import RouteRow from "./../components/RouteRow";

const Routess = () => {
  const [routess, setRoutess] = useState([]);

  useEffect(() => {
    console.log(`Route Component got loaded`);
    getRoutess();
  }, []);

  const getRoutess = () => {
    axios.get(url + "/admin/adminpanel/getallroutes").then((response) => {
      const result = response.data;
      console.log("Route:" + result.data);
      if (result.status === "success") {
        setRoutess(result.data);
      } else {
        alert("error while loading list of Route");
      }
    });
  };

  return (
    <div className="form-control">
      <h1 className="page-title">Routes</h1>

      <Link to="/add-route">
        <a className="btn btn-success">Add Route</a>
      </Link>
      <table className="table table-striped">
        <thead>
          <tr>
            <th>Route Name</th>
            <th>Source Station</th>
            <th>destination Station</th>
            <th>Gen Fair</th>
            <th>AC Fair</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {routess.map((route) => {
            return <RouteRow route={route} />;
          })}
        </tbody>
      </table>
    </div>
  );
};

export default Routess;
