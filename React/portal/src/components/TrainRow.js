import { useEffect, useState } from "react";
import { useHistory } from "react-router-dom";
import { url } from "../common/constants";
import axios from "axios";

const TrainRow = ({ train }) => {
  const history = useHistory();
  const [isAdmin, setIsAdmin] = useState(false);

  const bookTicket = () => {
    history.push({
      pathname: "/ticketform",
      state: { trainId: train.trainId },
    });
  };

  useEffect(() => {
    const userObject = localStorage.getItem("user");

    if (userObject !== null && userObject !== undefined) {
      const user = JSON.parse(userObject);
      console.log(
        "🚀 ~ file: App.js ~ line 26 ~ useEffect ~ user.role.toLowerCase",
        user
      );
      if (user.role.toLowerCase() === "admin") {
        setIsAdmin(true);
      }
    }
  });

  const deleteTrain = () => {
    axios
      .delete(url + "/admin/adminpanel/train/" + train.trainId)
      .then((response) => {
        const result = response.data;
        if (result.status === "success") {
          alert("Train Deleted");
        } else {
          alert("error while loading list of Train");
        }
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
      <td>₹{train.route.generalClassFair}</td>
      <td>₹{train.route.acClassFair}</td>
      <td>
        {isAdmin ? (
          <button
            onClick={() => {
              deleteTrain();
            }}
            className="btn btn-danger btn-sm"
          >
            Delete
          </button>
        ) : (
          <button onClick={() => bookTicket()} className="btn btn-info btn-sm ">
            Book
          </button>
        )}
      </td>
    </tr>
  );
};

export default TrainRow;
