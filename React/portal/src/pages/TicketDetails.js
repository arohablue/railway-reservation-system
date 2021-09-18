import React from "react";
import { useState } from "react";
import { useLocation, useHistory } from "react-router-dom";
import axios from "axios";
import Cards from "react-credit-cards";

import { url } from "../common/constants";
import PassengerRow from "../components/PassengerRow";
import "react-credit-cards/es/styles-compiled.css";

export default function TicketDetails() {
  const location = useLocation();
  const history = useHistory();
  const ticketDetails = location.state.ticketDetails.data;
  const [cvc, setCvc] = useState("");
  const [expiry, setExpiry] = useState("");
  const [focus, setFocus] = useState("");
  const [name, setName] = useState("");
  const [number, setNumber] = useState("");
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

  const handleInputFocus = (e) => {
    setFocus(e.target.name);
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
    <div className="form-control">
      <h1 className="page-title">Ticket Details</h1>
      {hidePayment && <div className="payment-complete">Payment Complete</div>}
      <div class="row">
        <h4 className="page-title">Train Info</h4>
        <div className="mb-3 col-md-3">
          <span className="grey-text">Train Number: </span>
          <span>{ticketDetails.train.trainNumber}</span>
        </div>
        <div className="mb-3 col-md-3">
          <span className="grey-text">PNR number: </span>
          <span>{ticketDetails.pnr}</span>
        </div>
        <div className="mb-3 col-md-3">
          <span className="grey-text">PNR status: </span>
          <span>{ticketDetails.status}</span>
        </div>
        <div className="mb-3 col-md-3">
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
      {!hidePayment && (
        <div id="PaymentForm">
          <h4 className="page-title">Payment System</h4>
          <Cards
            cvc={cvc}
            expiry={expiry}
            focused={focus}
            name={name}
            number={number}
          />
          <form className="d-flex flex-column w-50 mt-1 align-items-center card-form">
            <input
              type="tel"
              name="number"
              placeholder="Card Number"
              onChange={(e) => setNumber(e.target.value)}
              onFocus={handleInputFocus}
              className="mt-1"
            />
            <input
              type="text"
              name="name"
              placeholder="Card Holder name"
              onChange={(e) => setName(e.target.value)}
              onFocus={handleInputFocus}
              className="mt-1"
            />
            <input
              type="text"
              name="expiry"
              placeholder="Card Expiry"
              onChange={(e) => setExpiry(e.target.value)}
              onFocus={handleInputFocus}
              className="mt-1"
            />
            <input
              type="text"
              name="cvc"
              placeholder="CVC"
              onChange={(e) => setCvc(e.target.value)}
              onFocus={handleInputFocus}
              className="mt-1"
            />
            <button
              type="button"
              className="btn btn-success text-1 mt-2"
              onClick={(e) => {
                e.preventDefault();
                alert("Payment success");
                setHidePayment(true);
              }}
            >
              Make payment
            </button>
          </form>
        </div>
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
