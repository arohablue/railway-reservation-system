import React from "react";
import { useLocation, useHistory } from "react-router-dom";

export default function TicketDetails() {
  const location = useLocation();
  const ticketDetails = location.state.ticketDetails;
  return (
    <div className="form-control">
      <h1 className="page-title">Ticket Details</h1>
      <div>
        <span>Ticket Number</span>
        <span>{ticketDetails.trainNumber}</span>
      </div>
      <div>
        <span>PNR number</span>
        <span>{ticketDetails.pnr}</span>
      </div>
      <div>
        <span>PNR status</span>
        <span>{ticketDetails.status}</span>
      </div>
      <div>
        <span>Reservation Date</span>
        <span>{ticketDetails.reservationDate}</span>
      </div>
      <div>
        <span>Email</span>
        <span>{ticketDetails.user.email}</span>
      </div>
    </div>
  );
}
