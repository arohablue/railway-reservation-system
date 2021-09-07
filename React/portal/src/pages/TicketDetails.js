import React from "react";
import { useState } from "react";
import { useLocation, useHistory } from "react-router-dom";
import axios from "axios";
import { url } from "../common/constants";
import PassengerRow from "../components/PassengerRow";

export default function TicketDetails() {
  const location = useLocation();
  const history = useHistory();
  console.log(
    "🚀 ~ file: TicketDetails.js ~ line 6 ~ TicketDetails ~ location",
    location
  );
  const ticketDetails = location.state.ticketDetails.data;
  console.log(
    "🚀 ~ file: TicketDetails.js ~ line 7 ~ TicketDetails ~ ticketDetails",
    ticketDetails
  );

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

  return (
    <div className="form-control">
      <h1 className="page-title">Ticket Details</h1>
      <div class="row">
        <h4 className="page-title">Train Info</h4>
        <div className="mb-3 col-md-2">
          <span className="grey-text">Train Number: </span>
          <span>{ticketDetails.train.trainNumber}</span>
        </div>
        <div className="mb-3 col-md-2">
          <span className="grey-text">PNR number: </span>
          <span>{ticketDetails.pnr}</span>
        </div>
        <div className="mb-3 col-md-2">
          <span className="grey-text">PNR status: </span>
          <span>{ticketDetails.status}</span>
        </div>
        <div className="mb-3 col-md-2">
          <span className="grey-text">Journey Date: </span>
          <span>{ticketDetails.reservationDate}</span>
        </div>
      </div>
      <h4 className="page-title">User Info</h4>
      {ticketDetails.passengers.map((passenger) => {
        return <PassengerRow passenger={passenger} />;
      })}
      {ticketDetails.status !== "CANCELLED" && (
        <button
          className="btn btn-danger text-1"
          onClick={() => cancelTicket()}
        >
          Cancel Ticket
        </button>
      )}
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
