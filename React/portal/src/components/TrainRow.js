import { useHistory } from "react-router-dom";

const TrainRow = ({ train }) => {
  const history = useHistory();

  return (
    <tr>
      <td>{train.trainNumber}</td>
      <td>{train.trainName}</td>
      <td>{train.trainType}</td>
      <td>{train.noOfSeatsGen}</td>
      <td>{train.noOfSeatsAC}</td>
      <td>{train.departureTime}</td>
      <td>{train.arrivalTime}</td>
      <td>{train.route.sourceStation.stationName}</td>
      <td>{train.route.destinationStation.stationName}</td>
      <td>₹{train.route.acClassFair}</td>
      <td>₹{train.route.generalClassFair}</td>
      <td>
        <button
          onClick={() => {
            // /add-songs-to-album -> path of the component
            // {album: album}      -> data needed to be passed to the component
            history.push("/train", { train: train });
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
            history.push("/train", { train: train });
          }}
          className="btn btn-danger btn-sm "
        >
          Delete
        </button>
      </td>
    </tr>
  );
};

export default TrainRow;
