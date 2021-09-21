import React, { useState } from "react";
import { useHistory } from "react-router";
import axios from "axios";
import { url } from "../common/constants";

export default function Feedback() {
  const history = useHistory();

  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [suggestion, setSuggestion] = useState("");

  const onSubmit = () => {
    console.log("On Submit: ", email, name, suggestion);
    if (name === null || name.length === 0) {
      alert("Enter Name");
    } else if (email === null || email.length === 0) {
      alert("Enter email ");
    } else if (suggestion === null || suggestion.length === 0) {
      alert("Enter suggestion");
    } else {
      const data = {
        name: name,
        email: email,
        suggestion: suggestion,
      };

      axios.post(url + "/user/sendfeedback", data).then((response) => {
        const data = response.data;
        console.log("user: ", JSON.stringify(data));
        history.push("/thankyou");
      });
      history.push("/thankyou");
    }
  };

  return (
    <div>
      <div className="mt-3 page-title-bold">Please provide feedback</div>
      <div className="mb-3 col-md-3 ">
        <label className="label-bold">Name</label>
        <input
          onChange={(event) => {
            setName(event.target.value);
          }}
          value={name}
          placeholder="Enter Name"
          className="form-control"
          type="text"
          required={"Please enter name"}
        />
      </div>
      <div className="mb-3 col-md-3">
        <label className="label-bold">Email</label>
        <input
          onChange={(event) => {
            setEmail(event.target.value);
          }}
          value={email}
          placeholder="Enter Email"
          className="form-control"
          type="text"
          required
        />
      </div>
      <div className="mb-3 col-md-3">
        <label className="label-bold">Suggestion</label>
        <div>
          <textarea
            type="text"
            rows="4"
            cols="142"
            placeholder="Type your feedback..."
            onChange={(e) => setSuggestion(e.target.value)}
            value={suggestion}
            required
          />
        </div>
      </div>
      <button className="btn btn-primary" type="submit" onClick={onSubmit}>
        Submit
      </button>
      <img src="feedback.svg" />
    </div>
  );
}
