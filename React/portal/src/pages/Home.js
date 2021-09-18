import { useState } from "react";
import { useHistory } from "react-router-dom";
import axios from "axios";
import { url } from "../common/constants";

const Home = () => {
  const history = useHistory();

  const [pnr, setPnr] = useState(null);

  const searchPNR = () => {
    console.log("🚀 ~ file: Home.js ~ line 13 ~ searchPNR ~ pnr", pnr);
    if (pnr !== null && pnr !== "") {
      axios
        .post(url + `/user/checkpnr`, { pnr: pnr.toString() })
        .then((response) => {
          const ticketDetails = response.data;
          console.log(ticketDetails);
          if (
            ticketDetails.status === "success" &&
            ticketDetails.data.pnr !== null
          ) {
            history.push({
              pathname: "ticketdetails",
              state: { ticketDetails },
            });
          } else {
            alert(`No ticket found with PNR ${pnr}`);
          }
        });
    } else {
      alert("Enter a PNR to search status!");
    }
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
        <button className="btn btn-secondary mx-2" onClick={searchPNR}>
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
