import axios from "axios";
import { useState } from "react";
import "../Signup.css";
import { Link, useHistory } from "react-router-dom";
const url = "http://localhost:8080";

const Signin = () => {
  // define the state
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const history = useHistory();

  const signinUser = () => {
    console.log(`first name = ${email}`);
    console.log(`last name = ${password}`);

    if (email.length === 0) {
      alert("Enter email ");
    } else if (password.length === 0) {
      alert("Enter password");
    } else {
      const data = new FormData();
      console.log(data);
      console.log(email);
      console.log(password);

      //
      data.append("email", email);
      data.append("password", password);

      axios.post(url + "/user/authenticate", data).then((response) => {
        //const url = 'http://localhost:8080'
        const user = response.data;
        console.log("user: ", JSON.stringify(user));
        if (user !== "") {
          localStorage.setItem("user", JSON.stringify(user));
          window.location.replace("/");
        } else {
          console.log(user.error);
          alert("Incorrect Credentials");
        }
      });
    }
  };

  return (
    <div>
      <h1 className="page-title ">Sign in</h1>
      <div className="row container-center">
        <div className="mb-3 col-md-3">
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
        <div className="mb-3 col-md-3">
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
      <div className="row container-center">
        <div className="mb-3 col-md-3">
          <button onClick={signinUser} className="btn btn-success">
            Signin
          </button>
          {/* <Link className="nav-link" to="/home">
          already have an account
        </Link>
        <Link className="nav-link" to="/adminsignin">
          Admin Signin
        </Link>*/}
        </div>
        <div className="mb-3 col-md-3">
          <Link className="nav-link" to="/forgotpassword">
            Forgot password ?
          </Link>
        </div>
      </div>

      <img className="img-background-wrapper" src="signin.svg" />
    </div>
  );
};

export default Signin;
