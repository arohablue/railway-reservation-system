import React, { useEffect } from "react";
import { useHistory } from "react-router-dom";
import BounceLoader from "react-spinners/BounceLoader";

export default function SplashScreen() {
  const history = useHistory();
  useEffect(() => {
    const userObject = localStorage.getItem("user");

    if (userObject !== null && userObject !== undefined) {
      const user = JSON.parse(userObject);

      if (user.role.toLowerCase() === "admin") {
        history.push("/adminpanel");
      } else {
        history.push("/searchtrain");
      }
    } else {
      history.push("/signin");
    }
  });

  return (
    <div className="spinner">
      <BounceLoader size={60} color={"#000000"} loading={true}></BounceLoader>
    </div>
  );
}
