import React, { useState } from "react";
import { useLocation, useHistory } from "react-router-dom";
import axios from "axios";
import { url } from "../common/constants";

export default function TicketForm() {
  const location = useLocation();
  const history = useHistory();

  const [name, setName] = useState();
  const [age, setAge] = useState();
  const [email, setEmail] = useState();
  const [gender, setGender] = useState("male");

  const bookTicket = () => {
    let today = new Date();
    let dd = String(today.getDate()).padStart(2, "0");
    let mm = String(today.getMonth() + 1).padStart(2, "0");
    let hh = String(today.getHours() + 1).padStart(2, "0");
    let MM = String(today.getMinutes() + 1).padStart(2, "0");
    let yyyy = today.getFullYear();

    today = yyyy + "-" + mm + "-" + dd + " " + hh + ":" + MM;
    const requestData = {
      train: {
        trainId: location.state.trainId,
      },
      user: {
        userId: JSON.parse(localStorage.getItem("user")).id,
        age: age,
        name: name,
        gender: gender,
        email: email,
      },
      bookingDate: today,
      reservationDate: today,
    };

    axios.post(url + "/user/bookticket", requestData).then((response) => {
      const ticketDetails = response.data;
      console.log(
        "🚀 ~ file: TicketForm.js ~ line 28 ~ axios.post ~ ticketDetails",
        ticketDetails
      );
      history.push({ pathname: "/ticketdetails", state: { ticketDetails } });
    });
  };

  return (
    <div>
      <h2 className="mt-3">Enter Details to Book</h2>
      <div className="mb-3">
        <label>Name</label>
        <input
          onChange={(event) => {
            setName(event.target.value);
          }}
          placeholder="Enter Name"
          className="form-control"
          type="text"
        />
      </div>
      <div className="mb-3">
        <label>Age</label>
        <input
          onChange={(event) => {
            setAge(event.target.value);
          }}
          placeholder="Enter Age"
          className="form-control"
          type="number"
        />
      </div>
      <div className="mb-3">
        <label>Email</label>
        <input
          onChange={(event) => {
            setEmail(event.target.value);
          }}
          placeholder="Enter Email"
          className="form-control"
          type="email"
        />
      </div>
      <div className="mb-3">
        <label>Gender</label>
        <div>
          <select
            value={gender}
            onChange={(event) => setGender(event.target.value)}
          >
            <option value="male">Male</option>
            <option value="female">Female</option>
            <option value="other">Other</option>
          </select>
        </div>
      </div>
      <button onClick={() => bookTicket()} className="btn btn-info">
        Book Ticket
      </button>
    </div>
  );
}
