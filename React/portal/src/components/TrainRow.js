import { useHistory } from "react-router-dom";

const TrainRow = ({ train }) => {
  const history = useHistory();

  const bookTicket = () => {
    history.push({
      pathname: "/ticketform",
      state: { trainId: train.trainId },
    });
  };

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
        <button onClick={() => bookTicket()} className="btn btn-info btn-sm ">
          Book
        </button>
      </td>
    </tr>
  );
};

export default TrainRow;
