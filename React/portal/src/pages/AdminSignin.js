import axios from "axios";
import { useState } from "react";
import "../Signup.css";
import { Link, useHistory } from "react-router-dom";
const url = "http://localhost:8080";

const AdminSignin = () => {
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

      data.append("email", email);
      data.append("password", password);

      axios.post(url + "/admin/authenticate", data).then((response) => {
        //const url = 'http://localhost:8080'
        const result = response.data;
        console.log("hello");

        // if(result.status == 'success'){
        //     alert('Data Added Sucesssfully')
        alert("admin login successful");
        history.push("/adminpanel"); //similar to redirect

        // }
        // else{
        //     console.log(result.error)
        //     alert('Error While Adding Data')

        // }
      });
    }
  };
  return (
    <div className="form-control">
      <h1 className="page-title ">Sign in</h1>

      <div className="row ">
        <div className="mb-3 col-md-3">
          <label className="label-bold">Email</label>
          <input
            onChange={(event) => {
              setEmail(event.target.value);
            }}
            placeholder="Enter Admin Email"
            className="form-control"
            type="email"
          />
        </div>
        <div className="mb-3">
          <label className="label-bold">Password</label>
          <input
            onChange={(event) => {
              setPassword(event.target.value);
            }}
            placeholder="Enter Admin Password"
            className="form-control"
            type="password"
          />
        </div>
        <div className="mb-3">
          <button onClick={signinUser} className="btn btn-success">
            Signin
          </button>
          <Link className="nav-link" to="/home">
            already have an account
          </Link>
          <Link className="nav-link" to="/adminsignin">
            Admin Signin
          </Link>
        </div>
      </div>
    </div>
  );
};
export default AdminSignin;
