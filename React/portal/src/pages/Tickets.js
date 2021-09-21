import axios from "axios";
import React, { useState, useEffect } from "react";
import { url } from "../common/constants";
import TicketListRow from "../components/TicketListRow";

export default function Tickets() {
  const [ticketList, setTicketList] = useState([
    // {
    //   pnr: "33",
    //   status: "booked",
    //   bookingDate: "2021-03-04",
    //   reservationDate: "2021-04-03",
    //   train: {
    //     trainNumber: "234",
    //     noOfSeatsAC: "3",
    //     noOfSeatsGen: "12",
    //   },
    // },
  ]);
  console.log(
    "🚀 ~ file: Tickets.js ~ line 8 ~ Tickets ~ ticketList",
    ticketList
  );

  useEffect(() => {
    console.log("Getting tickets");
    axios.get(url + "/admin/adminpanel/getalltickets").then((response) => {
      console.log(response.data.data);
      setTicketList(response.data.data);
    });
  }, []);

  return (
    <div className="form-control">
      <h1 className="page-title">Tickets</h1>

      {/* <Link to="/add-user">
    <a className="btn btn-success">Add User</a>
  </Link> */}
      <table className="table table-striped">
        <thead>
          <tr>
            <th>Train number</th>
            <th>PNR number</th>
            <th>PNR status</th>
            <th>Booking Date</th>
            <th>Reservation Date</th>
            {/* <th>AC seats</th>
            <th>GEN seats</th> */}
            {/* <th>Actions</th> */}
          </tr>
        </thead>
        <tbody>
          {ticketList.map((ticket) => {
            return <TicketListRow ticket={ticket} />;
          })}
        </tbody>
      </table>
      <img className="img-background-wrapper" src="station.svg" />
    </div>
  );
}
