import React from "react";
import { useState } from "react";
import { Link, useLocation, useHistory } from "react-router-dom";
import axios from "axios";
import Cards from "react-credit-cards";

import { url } from "../common/constants";
import PassengerRow from "../components/PassengerRow";
import "react-credit-cards/es/styles-compiled.css";

export default function TicketDetails() {
  const location = useLocation();
  const history = useHistory();
  const ticketDetails = location.state.ticketDetails.data;
  const [hidePayment, setHidePayment] = useState(false);
  const cancelTicket = () => {
    axios
      .post(url + "/user/cancelticket", { pnr: ticketDetails.pnr })
      .then((response) => {
        console.log("Data" + response.data.data);
        if (response.data.status === "success") {
          alert("Ticket cancellation success");
          history.push("/searchtrain");
        }
      });
  };

  // const handleInputChange = (e) => {
  //   const { name, value } = e.target;
  //   console.log(
  //     "🚀 ~ file: TicketDetails.js ~ line 39 ~ handleInputChange ~ name",
  //     name,
  //     value
  //   );
  // };

  return (
    <div className="">
      <h1 className="page-title">Ticket Details</h1>
      {hidePayment && <div className="payment-complete">Payment Complete</div>}

      <div class="row container-center form-control">
        <div className="col-md-3">
          <h4 className="page-title">Train Info</h4>
          <div className="mb-3">
            <span className="grey-text">Train Number: </span>
            <span className="label-bold">
              {ticketDetails.train.trainNumber}
            </span>
          </div>
          <div className="mb-3 ">
            <span className="grey-text">PNR number: </span>
            <span className="label-bold">{ticketDetails.pnr}</span>
          </div>
          <div className="mb-3">
            <span className="grey-text">PNR status: </span>
            <span className="label-bold">{ticketDetails.status}</span>
          </div>
          <div className="mb-3">
            <span className="grey-text">Journey Date: </span>
            <span className="label-bold">{ticketDetails.reservationDate}</span>
          </div>
        </div>
      </div>
      <br />
      <div class="row passengers container-center form-control">
        <h4 className="page-title">User Info</h4>{" "}
        {ticketDetails.passengers.map((passenger) => {
          return <PassengerRow passenger={passenger} />;
        })}
      </div>
      <br />

      {ticketDetails.status !== "CANCELLED" && (
        <button
          className="btn btn-danger text-1"
          onClick={() => cancelTicket()}
        >
          Cancel Ticket
        </button>
      )}
      <Link className="nav-link" to="/home">
        Back
      </Link>
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
  );
}
