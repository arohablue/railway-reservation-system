import axios from "axios";
import { useHistory } from "react-router-dom";
import { url } from "../common/constants";
import { useState, useEffect } from "react";

const StationRow = ({ station }) => {
  const history = useHistory();
  const [deleted, setDeleted] = useState("");

  useEffect(() => {}, [deleted]);

  const deleteStation = () => {
    axios
      .delete(url + "/admin/adminpanel/station/" + station.stationId)
      .then((response) => {
        const result = response.data;
        if (result.status === "success") {
          alert("Station Deleted");
          history.push({
            pathname: "/",
          });
        } else {
          alert("error while deleting Station");
        }
      });
  };

  return (
    <tr>
      <td>{station.stationName}</td>
      <td>
        <button
          onClick={() => {
            deleteStation();
          }}
          className="btn btn-danger btn-sm "
        >
          Delete
        </button>
      </td>
    </tr>
  );
};

export default StationRow;
