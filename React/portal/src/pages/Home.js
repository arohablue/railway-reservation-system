import { useState } from "react";
import { useHistory } from "react-router-dom";
import axios from "axios";
import { url } from "../common/constants";

const Home = () => {
  const history = useHistory();

  const [pnr, setPnr] = useState(null);

  const searchPNR = () => {
    axios
      .post(url + `/user/checkpnr`, { pnr: pnr.toString() })
      .then((response) => {
        const ticketDetails = response.data;

        history.push({ pathname: "ticketdetails", state: { ticketDetails } });
      });
  };

  return (
    <div>
      <h2 className="page-title">Welcome</h2>
      <div>
        <div>Check PNR Status</div>
        <input
          type="number"
          onChange={(e) => {
            setPnr(e.target.value);
          }}
        />
        <button
          className="btn btn-secondary mx-2"
          onClick={() => {
            searchPNR();
          }}
        >
          Search
        </button>
      </div>
      <div className="mt-4">OR</div>
      <button
        className="btn btn-info mt-4"
        onClick={() => history.push("/searchtrain")}
      >
        Search Trains
      </button>
    </div>
  );
};

export default Home;
