import axios from "axios";
import { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import { url } from "../common/constants";
import RouteRow from "../components/RouteRow";

const Routes = () => {
  const [routes, setRoutes] = useState([]);

  useEffect(() => {
    console.log(`Route Component got loaded`);
    getRoutes();
  }, []);

  const getRoutes = () => {
    axios.get(url + "/admin/adminpanel/getallroutes").then((response) => {
      const result = response.data;
      console.log("Route:" + result.data);
      if (result.status === "success") {
        setRoutes(result.data);
      } else {
        alert("error while loading list of Route");
      }
    });
  };

  return (
    <div className="form-control">
      <h1 className="page-title">Routes</h1>

      <Link to="/add-route" className="btn btn-success">
        Add Route
      </Link>
      <table className="table table-striped">
        <thead>
          <tr>
            <th>Route Name</th>
            <th>Source Station</th>
            <th>destination Station</th>
            <th>Gen Fair</th>
            <th>AC Fair</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {routes.map((route) => {
            return <RouteRow route={route} />;
          })}
        </tbody>
      </table>
      <img className="img-background-wrapper" src="routes.svg" />
    </div>
  );
};

export default Routes;
