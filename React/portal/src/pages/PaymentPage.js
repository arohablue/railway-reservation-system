import React from "react";
import { useState } from "react";
import { useLocation, useHistory } from "react-router-dom";
import axios from "axios";
import Cards from "react-credit-cards";

import { url } from "../common/constants";
import PassengerRow from "../components/PassengerRow";
import "react-credit-cards/es/styles-compiled.css";

export default function PaymentPage() {
  const location = useLocation();
  const history = useHistory();
  const requestData = location.state.requestData;
  const [cvc, setCvc] = useState("");
  const [expiry, setExpiry] = useState("");
  const [focus, setFocus] = useState("");
  const [name, setName] = useState("");
  const [number, setNumber] = useState("");
  const [hidePayment, setHidePayment] = useState(false);

  const makePayment = () => {
    if (number !== null && name !== null && expiry != null) {
      requestData.cardNumber = number;
      requestData.cardHolderName = name;
      requestData.cardExpiry = expiry;

      axios.post(url + "/user/bookticket", requestData).then((response) => {
        const ticketDetails = response.data;
        alert("Payment success");
        setHidePayment(true);
        console.log(
          "🚀 ~ file: TicketForm.js ~ line 28 ~ axios.post ~ ticketDetails",
          ticketDetails
        );
        history.push({ pathname: "/ticketdetails", state: { ticketDetails } });
      });
    } else {
      alert("Enter Card details!");
    }

    // axios
    //   .post(url + "/user/payment", {
    //     pnr: requestData.pnr,
    //     paymentDetails: {
    //       cardNumber: number,
    //       name: name,
    //       expiry: expiry,
    //     },
    //   })
    //   .then((response) => {
    //     const ticketDetails = response.data;
    //     console.log(
    //       "🚀 ~ file: PaymentPage.js ~ line 35 ~ axios.post ~ PaymentPage",
    //       ticketDetails
    //     );
    //     history.push({ pathname: "/ticketdetails", state: { ticketDetails } });
    //   });
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
      <h1 className="page-title">Payment Info</h1>
      {!hidePayment && (
        <div id="PaymentForm">
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
                makePayment();
              }}
            >
              Make payment
            </button>
          </form>
        </div>
      )}
    </div>
  );
}
