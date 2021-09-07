import axios from "axios";
import { useHistory } from "react-router-dom";
import { url } from "../common/constants";

const PassengerRow = ({ passenger }) => {
  const history = useHistory();

  return (
    <div class="row">
      <div className="mb-3 col-md-3">
        <span className="grey-text">Name: </span>
        <span>{passenger.name}</span>
      </div>
      <div className="mb-3 col-md-3">
        <span className="grey-text">Age: </span>
        <span>{passenger.age}</span>
      </div>
      <div className="mb-3 col-md-3">
        <span className="grey-text">Gender: </span>
        <span>{passenger.gender}</span>
      </div>
      <div className="mb-3 col-md-3">
        <span className="grey-text">Email: </span>
        <span>{passenger.email}</span>
      </div>
    </div>
  );
};

export default PassengerRow;
