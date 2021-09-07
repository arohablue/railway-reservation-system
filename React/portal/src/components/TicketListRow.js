import React, { useState } from "react";

export default function TicketListRow({ ticket }) {
  console.log(
    "🚀 ~ file: TicketListRow.js ~ line 4 ~ TicketListRow ~ ticket",
    ticket
  );
  const [status, setStatus] = useState(null);
  return (
    <tr>
      <td>{ticket.train.trainNumber}</td>
      <td>{ticket.pnr}</td>
      <td>{ticket.status}</td>
      <td>{ticket.bookingDate}</td>
      <td>{ticket.reservationDate}</td>
      {/* <td>{ticket.train.noOfSeatsAC}</td>
      <td>{ticket.train.noOfSeatsGen}</td> */}
      {/* <td>
        <select
          value={status}
          onChange={(event) => setStatus(event.target.value)}
        >
          <option value="CONFIRMED">CONFIRMED</option>
          <option value="CANCELLED">CANCELLED</option>
        </select>
      </td> */}
    </tr>
  );
}
