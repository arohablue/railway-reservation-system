import React from "react";
import { useLocation, useHistory } from "react-router-dom";

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
  return (
    <div className="form-control">
      <h1 className="page-title">Ticket Details</h1>
      <div>
        <span className="grey-text">Ticket Number: </span>
        <span>{ticketDetails.train.trainNumber}</span>
      </div>
      <div>
        <span className="grey-text">PNR number: </span>
        <span>{ticketDetails.pnr}</span>
      </div>
      <div>
        <span className="grey-text">PNR status: </span>
        <span>{ticketDetails.status}</span>
      </div>
      <div>
        <span className="grey-text">Journey Date: </span>
        <span>{ticketDetails.reservationDate}</span>
      </div>
      <div>
        <span className="grey-text">Email: </span>
        <span>{ticketDetails.user.email}</span>
      </div>
      <div className="mt-3 text-1">Help us improve</div>
      <button
        className="btn btn-info text-1"
        onClick={() => history.push("/feedback")}
      >
        Give feedback
      </button>
    </div>
  );
}
