import React, { useState } from "react";
import { useLocation, useHistory } from "react-router-dom";
import axios from "axios";
import { url } from "../common/constants";

export default function TicketForm() {
  const location = useLocation();
  const history = useHistory();

  const [name, setName] = useState(null);
  const [age, setAge] = useState(null);
  const [email, setEmail] = useState(null);
  const [gender, setGender] = useState("None");
  const [name1, setName1] = useState(null);
  const [age1, setAge1] = useState(null);
  const [email1, setEmail1] = useState(null);
  const [gender1, setGender1] = useState("None");
  const [name2, setName2] = useState(null);
  const [age2, setAge2] = useState(null);
  const [email2, setEmail2] = useState(null);
  const [gender2, setGender2] = useState("None");
  const [name3, setName3] = useState(null);
  const [age3, setAge3] = useState(null);
  const [email3, setEmail3] = useState(null);
  const [gender3, setGender3] = useState("None");
  const [bookingClass, setBookingClass] = useState("AC");

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
      },
      passengers: [
        {
          name: name,
          age: age,
          email: email,
          gender: gender,
        },
        {
          name: name1,
          age: age1,
          email: email1,
          gender: gender2,
        },
        {
          name: name2,
          age: age2,
          email: email2,
          gender: gender2,
        },
        {
          name: name3,
          age: age3,
          email: email3,
          gender: gender3,
        },
      ],
      bookingClass: bookingClass,
      bookingDate: today,
      reservationDate: today,
      cardNumber: "",
      cardHolderName: "",
      cardExpiry: "",
    };

    if (
      requestData.passengers[0].name !== null &&
      requestData.passengers[0].age !== null &&
      requestData.passengers[0].email !== null &&
      requestData.passengers[0].gender !== "None"
    ) {
      history.push({ pathname: "/payment", state: { requestData } });
    } else {
      alert("Enter Passenger details!");
    }
  };

  return (
    <div className="white-background">
      <h2 className="mt-3 page-title">Enter Details to Book</h2>
      <div className="mb-3 col-md-3">
        <label className="label-bold">Booking Class</label>
        <div>
          <select
            value={bookingClass}
            onChange={(event) => setBookingClass(event.target.value)}
          >
            <option value="AC">AC</option>
            <option value="GEN">GEN</option>
          </select>
        </div>
      </div>
      <div class="row">
        <h4 className="mt-3">Passenger 1</h4>
        <div className="mb-3 col-md-3">
          <label className="label-bold">Name</label>
          <input
            onChange={(event) => {
              setName(event.target.value);
            }}
            placeholder="Enter Name"
            className="form-control"
            type="text"
          />
        </div>
        <div className="mb-3 col-md-3">
          <label className="label-bold">Age</label>
          <input
            onChange={(event) => {
              setAge(event.target.value);
            }}
            placeholder="Enter Age"
            className="form-control"
            type="number"
          />
        </div>
        <div className="mb-3 col-md-3">
          <label className="label-bold">Email</label>
          <input
            onChange={(event) => {
              setEmail(event.target.value);
            }}
            placeholder="Enter Email"
            className="form-control"
            type="email"
          />
        </div>
        <div className="mb-3 col-md-3">
          <label className="label-bold">Gender</label>
          <div>
            <select
              value={gender}
              onChange={(event) => setGender(event.target.value)}
            >
              <option value="None">None</option>
              <option value="male">Male</option>
              <option value="female">Female</option>
              <option value="other">Other</option>
            </select>
          </div>
        </div>
      </div>
      <div class="row">
        <h4 className="mt-3">Passenger 2</h4>
        <div className="mb-3 col-md-3">
          <label className="label-bold">Name</label>
          <input
            onChange={(event) => {
              setName1(event.target.value);
            }}
            placeholder="Enter Name"
            className="form-control"
            type="text"
          />
        </div>
        <div className="mb-3 col-md-3">
          <label className="label-bold">Age</label>
          <input
            onChange={(event) => {
              setAge1(event.target.value);
            }}
            placeholder="Enter Age"
            className="form-control"
            type="number"
          />
        </div>
        <div className="mb-3 col-md-3">
          <label className="label-bold">Email</label>
          <input
            onChange={(event) => {
              setEmail1(event.target.value);
            }}
            placeholder="Enter Email"
            className="form-control"
            type="email"
          />
        </div>
        <div className="mb-3 col-md-3">
          <label className="label-bold">Gender</label>
          <div>
            <select
              value={gender1}
              onChange={(event) => setGender1(event.target.value)}
            >
              <option value="None">None</option>
              <option value="male">Male</option>
              <option value="female">Female</option>
              <option value="other">Other</option>
            </select>
          </div>
        </div>
      </div>
      <div class="row">
        <h4 className="mt-3">Passenger 3</h4>
        <div className="mb-3 col-md-3">
          <label className="label-bold">Name</label>
          <input
            onChange={(event) => {
              setName2(event.target.value);
            }}
            placeholder="Enter Name"
            className="form-control"
            type="text"
          />
        </div>
        <div className="mb-3 col-md-3">
          <label className="label-bold">Age</label>
          <input
            onChange={(event) => {
              setAge2(event.target.value);
            }}
            placeholder="Enter Age"
            className="form-control"
            type="number"
          />
        </div>
        <div className="mb-3 col-md-3">
          <label className="label-bold">Email</label>
          <input
            onChange={(event) => {
              setEmail2(event.target.value);
            }}
            placeholder="Enter Email"
            className="form-control"
            type="email"
          />
        </div>
        <div className="mb-3 col-md-3">
          <label className="label-bold">Gender</label>
          <div>
            <select
              value={gender2}
              onChange={(event) => setGender2(event.target.value)}
            >
              <option value="None">None</option>
              <option value="male">Male</option>
              <option value="female">Female</option>
              <option value="other">Other</option>
            </select>
          </div>
        </div>
      </div>
      <div class="row">
        <h4 className="mt-3">Passenger 4</h4>
        <div className="mb-3 col-md-3">
          <label className="label-bold">Name</label>
          <input
            onChange={(event) => {
              setName3(event.target.value);
            }}
            placeholder="Enter Name"
            className="form-control"
            type="text"
          />
        </div>
        <div className="mb-3 col-md-3">
          <label className="label-bold">Age</label>
          <input
            onChange={(event) => {
              setAge3(event.target.value);
            }}
            placeholder="Enter Age"
            className="form-control"
            type="number"
          />
        </div>
        <div className="mb-3 col-md-3">
          <label className="label-bold">Email</label>
          <input
            onChange={(event) => {
              setEmail3(event.target.value);
            }}
            placeholder="Enter Email"
            className="form-control"
            type="email"
          />
        </div>
        <div className="mb-3 col-md-3">
          <label className="label-bold">Gender</label>
          <div>
            <select
              value={gender3}
              onChange={(event) => setGender3(event.target.value)}
            >
              <option value="None">None</option>
              <option value="male">Male</option>
              <option value="female">Female</option>
              <option value="other">Other</option>
            </select>
          </div>
        </div>
      </div>
      <button onClick={() => bookTicket()} className="btn btn-info">
        Book Ticket
      </button>
    </div>
  );
}
