import axios from "axios";
import { useState, useEffect } from "react";
import { Link, useHistory } from "react-router-dom";
import { url } from "../common/constants";

const AddStation = () => {
  const [stationName, setStationName] = useState("");

  const history = useHistory();

  const addStationToDB = () => {
    if (stationName.length === 0) {
      alert("enter station name");
    } else {
      const data = new FormData();
      data.append("stationName", stationName);

      // send the album info to the API
      axios
        .post(url + "/admin/adminpanel/addstation", data)
        .then((response) => {
          const result = response.data;
          if (result.status === "success") {
            alert("successfully added new Station");
            history.push("/station");
          } else {
            console.log(result.error);
            alert("error while loading Station");
          }
        });
    }
  };

  return (
    <div>
      <h1 className="page-title">Add Station</h1>
      <div className="mb-3">
        <label htmlFor="">Station Name</label>
        <input
          onChange={(e) => {
            setStationName(e.target.value);
          }}
          type="text"
          className="form-control"
        />
      </div>

      <div className="mb-3">
        <button onClick={addStationToDB} className="btn btn-success">
          Add
        </button>

        <Link to="/station">
          <a className="btn btn-warning">Back</a>
        </Link>
      </div>
    </div>
  );
};

export default AddStation;
