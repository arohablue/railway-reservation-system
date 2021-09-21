import { useState } from "react";
import axios from "axios";
import { Link, useHistory } from "react-router-dom";
import { url } from "../common/constants";

const ChangePassword = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");
  const [otp, setOtp] = useState("");
  const [otpSent, setOtpSent] = useState(false);
  const [otpConfirm, setOtpConfirm] = useState(false);

  const history = useHistory();

  const sendOtp = () => {
    if (email.length === 0) {
      alert("Please enter an Email Id");
    } else if (!/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email)) {
      alert("Please enter a valid Email Id");
    } else {
      const data = {
        email: email,
      };
      axios.post(url + "/user/sendotp", data).then((response) => {
        const result = response.data;
        alert("successful");

        if (result.status === "success") {
          alert("OTP sent to your email address");
          setOtpSent(true);
        } else {
          alert("Error While sending OTP");
        }
      });
    }
    setOtpSent(true);
  };

  const verifyOtp = () => {
    if (otp.length === 0) {
      alert("Please enter OTP sent to your email Id");
    } else {
      const data = {
        email: email,
        otp: otp,
      };

      axios.post(url + "/user/verifyotp", data).then((response) => {
        const result = response.data;
        alert("successful");

        if (result.status === "success") {
          alert("OTP Confirm");
          setOtpConfirm(true);
        } else {
          alert("Error While sending OTP");
        }
      });
    }
    setOtpConfirm(true);
  };

  const changePassword = () => {
    if (password.length === 0) {
      alert("Enter You Email");
    } else if (confirmPassword.length === 0) {
      alert("Enter Confirm Password");
    } else if (confirmPassword !== password) {
      alert("New password and confirm passwords does not match");
    } else {
      const data = {
        email: email,
        password: password,
      };

      axios.post(url + "/user/changepassword", data).then((response) => {
        const result = response.data;

        if (result.status === "success") {
          alert("Password Updated Successfully");
          history.push("/signin");
        } else {
          alert("Error While Updating Password");
        }
      });
    }
  };

  return (
    <div className="style">
      <h1 className="page-title">Change Your Password</h1>
      <div className="container-center">
        <div className="mb-3 col-md-3 ">
          <div className="mb-3 ">
            <label className="label-bold">Email</label>
            <input
              onChange={(event) => {
                // updating the state with user entered value
                setEmail(event.target.value);
              }}
              className="form-control"
              type="email"
              placeholder="Enter Your Email"
            />
            {otpSent && !otpConfirm && (
              <div className="mt-3">
                <label className="label-bold">OTP</label>
                <input
                  onChange={(event) => {
                    setOtp(event.target.value);
                  }}
                  className="form-control"
                  type="OTP"
                  placeholder="Enter Your OTP"
                />
                <button onClick={verifyOtp} className="btn btn-success mt-3">
                  Verify OTP
                </button>
              </div>
            )}
          </div>
          <div className="mb-3 ">
            {!otpSent && (
              <button onClick={sendOtp} className="btn btn-success">
                Send OTP
              </button>
            )}
          </div>
          {otpConfirm && (
            <div className="mb-3">
              <label className="label-bold">New Password</label>
              <input
                onChange={(event) => {
                  // updating the state with user entered value
                  setPassword(event.target.value);
                }}
                className="form-control"
                type="password"
                placeholder="Enter New Password"
              />
              <label className="label-bold">Confirm New Password</label>
              <input
                onChange={(event) => {
                  // updating the state with user entered value
                  setConfirmPassword(event.target.value);
                }}
                className="form-control"
                type="password"
                placeholder="Enter New Password"
              />
            </div>
          )}
          <div className="mb-3 col-md-3">
            {otpConfirm && (
              <button onClick={changePassword} className="btn btn-success">
                Change Password
              </button>
            )}
            <Link className="nav-link" to="/signin">
              Back
            </Link>
          </div>
        </div>
      </div>
      <img src="forgot-password.svg" />
    </div>
  );
};

export default ChangePassword;
