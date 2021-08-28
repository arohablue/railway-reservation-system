import { useHistory } from "react-router-dom";

const RouteRow = ({ route }) => {
  const history = useHistory();

  return (
    <tr>
      <td>{route.routeId}</td>
      <td>{route.sourceStation.stationName}</td>
      <td>{route.destinationStation.stationName}</td>
      <td>{route.acClassFair}</td>
      <td>{route.generalClassFair
       }</td>
      <td>
        <button
          onClick={() => {
            // /add-songs-to-album -> path of the component
            // {album: album}      -> data needed to be passed to the component
            history.push("/signin", { route: route });
          }}
          className="btn btn-warning btn-sm"
        >
          Edit
        </button>
        {/* <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>  */}
        <button
          onClick={() => {
            // /add-songs-to-album -> path of the component
            // {album: album}      -> data needed to be passed to the component
            history.push("/signin", { route: route });
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
