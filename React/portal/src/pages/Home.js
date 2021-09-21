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
    <div className="background-image-home">
      <h2 className="page-title">Welcome</h2>
      <div className="row container-center">
        <div className="col-md-3">
          <div>
            <div>Check PNR Status</div>
            <input
              type="number"
              onChange={(e) => {
                setPnr(e.target.value);
              }}
            />
            <button className="btn btn-success mx-2" onClick={searchPNR}>
              Search
            </button>
          </div>
          <div className="mt-4">OR</div>
          <button
            className="btn btn-success mt-4"
            onClick={() => history.push("/searchtrain")}
          >
            Search Trains
          </button>
        </div>
      </div>
      <br />
      <div className="row container-center">
        <div className="col-md-3">
          <div className="mt-3 text-1 grey-text">
            Help us improve our portal's user experience
          </div>
          <button
            className="btn btn-info text-1"
            onClick={() => history.push("/feedback")}
          >
            Give feedback
          </button>
        </div>
      </div>
      <img src="train.svg" />
    </div>
  );
};

export default Home;
