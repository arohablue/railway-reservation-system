import axios from "axios";
import { useState } from "react";
import "../Signup.css";
import { Link, useHistory } from "react-router-dom";
const url = "http://localhost:8080";
const qs = require("qs");

const Signup = () => {
  // define the state
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [age, setAge] = useState(0);
  const [gender, setGender] = useState("");
  const [mobile, setMobile] = useState("");
  const [state, setState] = useState("");
  const [city, setCity] = useState("");
  const [role, setRole] = useState("");
  const [authCode, setAuthCode] = useState("");
  const history = useHistory();

  const signupUser = () => {
    console.log(`email = ${email}`);
    console.log(`password = ${password}`);
    console.log(`age = ${age}`);
    console.log(`gender = ${gender}`);
    console.log(`mobile = ${mobile}`);
    console.log(`state = ${state}`);
    console.log(`city = ${city}`);
    console.log(`role = ${role}`);

    if (email.length === 0) {
      alert("Enter Email");
    }

    if (password.length === 0) {
      alert("Enter password");
    } else if (age.length === 0) {
      alert("Enter age");
    } else if (gender.length === 0) {
      alert("Enter gender ");
    } else if (mobile.length === 0) {
      alert("Enter mobile");
    } else if (state.length === 0) {
      alert("Enter state");
    } else if (city.length === 0) {
      alert("Enter city");
    } else if (role.length === 0) {
      alert("Enter role");
    } else if (
      (role === "Admin" || role === "Agent") &&
      authCode.length === 0
    ) {
      alert("Enter Auth code");
    } else {
      console.log("Here");
      const data = new FormData();
      console.log(data);
      console.log(email);
      console.log(password);
      console.log(age);
      console.log(gender);
      console.log(mobile);
      console.log(state);
      console.log(city);
      console.log(role);

      data.append("email", email);
      data.append("password", password);
      data.append("age", age);
      data.append("gender", gender);
      data.append("mobile", mobile);
      data.append("state", state);
      data.append("city", city);
      data.append("role", role);
      data.append("adminKey", authCode);
      console.log(data);

      axios.post(url + "/user/signup", data).then((response) => {
        //const url = 'http://localhost:8080'
        const result = response.data;

        if (result.status == "success") {
          alert("User created successfully");

          history.push("/signin"); //similar to redirect
        } else {
          console.log(result.error);
          alert("Error While Creating User: " + result.error);
        }
      });
      // axios({
      //   method: 'post',
      //   url: 'http://localhost:8080/user/signup',
      //   data: qs.stringify(data),
      //   headers: { Accept: 'application/json',

      //     'Content-Type': 'form-data' },
      // })
      //   .then(function (response) {
      //     //handle success
      //     console.log(response);
      //   })
      //   .catch(function (response) {
      //     //handle error
      //     console.log(response);
      //   });
    }
  };

  return (
    <div className="mt-3 mb-3">
      <div className="container">
        <h1>Sign up</h1>
        <div class="row">
          <div className="mb-3 col-md-6">
            <label className="label-bold">Email</label>
            <input
              onChange={(event) => {
                setEmail(event.target.value);
              }}
              placeholder="enter email"
              className="form-control"
              type="email"
            />
          </div>
          <div className="mb-3 col-md-6">
            <label className="label-bold">Password</label>
            <input
              onChange={(event) => {
                setPassword(event.target.value);
              }}
              placeholder="enter password"
              className="form-control"
              type="password"
            />
          </div>
        </div>
        <div class="row">
          <div className="mb-3 col-md-6">
            <label className="label-bold">Age</label>
            <input
              onChange={(event) => {
                setAge(event.target.value);
              }}
              placeholder="enter age"
              className="form-control"
              type="number"
            />
          </div>
          <div className="mb-3 col-md-6">
            <label className="label-bold">Gender</label>
            <input
              onChange={(event) => {
                setGender(event.target.value);
              }}
              placeholder="enter gender"
              className="form-control"
              type="text"
            />
          </div>
        </div>
        <div class="row">
          <div className="mb-3 col-md-6">
            <label className="label-bold">Mobile</label>
            <input
              onChange={(event) => {
                setMobile(event.target.value);
              }}
              placeholder="enter mobile"
              className="form-control"
              type="text"
            />
          </div>
          <div className="mb-3 col-md-6">
            <label className="label-bold">State</label>
            <input
              onChange={(event) => {
                setState(event.target.value);
              }}
              placeholder="enter state"
              className="form-control"
              type="text"
            />
          </div>
        </div>
        <div class="row">
          <div className="mb-3 col-md-6">
            <label className="label-bold">City</label>
            <input
              onChange={(event) => {
                setCity(event.target.value);
              }}
              placeholder="enter city"
              className="form-control"
              type="text"
            />
          </div>
          <div className="mb-3 col-md-6">
            <label className="label-bold">Auth Code</label>
            <input
              onChange={(event) => {
                setAuthCode(event.target.value);
              }}
              placeholder="enter Auth code"
              className="form-control"
              type="text"
            />
          </div>
        </div>
        <div class="row">
          <div className="mb-3 col-md-6">
            <label className="label-bold">Role :</label>
            <select
              name="role"
              id="role"
              onChange={(event) => {
                setRole(event.target.value);
              }}
            >
              <option value="">None</option>
              <option value="Admin">Admin</option>
              <option value="User">User</option>
              <option value="Agent">Agent</option>
            </select>
          </div>
          <div className="mb-3 col-md-6">
            <button onClick={signupUser} className="btn btn-success">
              Signup
            </button>
            {/* <Link className="nav-link" to="/signin">
            already have an account
          </Link> */}
          </div>
        </div>
      </div>
    </div>
  );
};

export default Signup;
