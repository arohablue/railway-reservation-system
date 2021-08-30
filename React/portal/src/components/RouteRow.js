import { useHistory } from "react-router-dom";
import { url } from "../common/constants";
import axios from "axios";

const RouteRow = ({ route }) => {
  const history = useHistory();

  const deleteRoute = () => {
    axios.delete(url + "/admin//adminpanel/route/", route.routeId).then((response) => {
      const result = response.data;
      if (result.status === "success") {
        alert("Route Deleted");
      } else {
        alert("error while deleting Route");
      }
    });
  };
  return (
    <tr>
      <td>{route.routeId}</td>
      <td>{route.sourceStation.stationName}</td>
      <td>{route.destinationStation.stationName}</td>
      <td>{route.acClassFair}</td>
      <td>{route.generalClassFair}</td>
      <td>
        {/* <button
          onClick={() => {
            // /add-songs-to-album -> path of the component
            // {album: album}      -> data needed to be passed to the component
            history.push("/signin", { route: route });
          }}
          className="btn btn-warning btn-sm"
        >
          Edit
        </button> */}
        <button
          onClick={() => {
            deleteRoute();
            history.push("/routes");
          }}
          className="btn btn-danger btn-sm "
        >
          Delete
        </button>
      </td>
    </tr>
  );
};

export default RouteRow;
