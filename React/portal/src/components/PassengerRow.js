import axios from "axios";
import { useHistory } from "react-router-dom";
import { url } from "../common/constants";

const PassengerRow = ({ passenger }) => {
  const history = useHistory();

  return (
    <div class="row">
      <div className="mb-3 col-md-3">
        <span className="grey-text">Name: </span>
        <span className="label-bold">{passenger.name}</span>
      </div>
      <div className="mb-3 col-md-3 ">
        <span className="grey-text">Age: </span>
        <span className="label-bold"> {passenger.age}</span>
      </div>
      <div className="mb-3 col-md-3">
        <span className="grey-text">Gender: </span>
        <span className="label-bold">{passenger.gender}</span>
      </div>
      <div className="mb-3  col-md-3">
        <span className="grey-text">Email: </span>
        <span className="label-bold">{passenger.email}</span>
      </div>
    </div>
  );
};

export default PassengerRow;
