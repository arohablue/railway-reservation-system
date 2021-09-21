import "./App.css";
import { useState, useEffect } from "react";
import { BrowserRouter, Link, Route, Switch } from "react-router-dom";
import Home from "./pages/Home";
import Signin from "./pages/Signin";
import Signup from "./pages/Signup";
import AdminSignin from "./pages/AdminSignin";
import AdminPanel from "./pages/AdminPanel";
import ChangePassword from "./pages/ChangePassword";
import SearchTrain from "./pages/SearchTrain";
import SplashScreen from "./pages/SplashScreen";
import TicketForm from "./pages/TicketForm";
import TicketDetails from "./pages/TicketDetails";
import Feedback from "./pages/Feedback";
import Thankyou from "./pages/Thankyou";
import PaymentPage from "./pages/PaymentPage";

function App() {
  const [signedIn, setSignedIn] = useState(false);
  const [isAdmin, setIsAdmin] = useState(false);
  const userObject = localStorage.getItem("user");

  useEffect(() => {
    const userObject = localStorage.getItem("user");

    if (userObject !== null && userObject !== undefined) {
      const user = JSON.parse(userObject);
      console.log(
        "🚀 ~ file: App.js ~ line 26 ~ useEffect ~ user.role.toLowerCase",
        user
      );
      if (user.role.toLowerCase() === "admin") {
        setIsAdmin(true);
      }
      setSignedIn(true);
    } else {
      setSignedIn(false);
    }
  }, [userObject]);

  const logoutUser = () => {
    localStorage.removeItem("user");
    window.location.replace("/");
  };

  return (
    <div>
      <BrowserRouter>
        <nav className="navbar navbar-expand-lg navbar-light bg-light">
          <div className="container-fluid">
            <Link className="navbar-brand" to="/">
              Railway Reservation System
            </Link>
            <button
              className="navbar-toggler"
              type="button"
              data-bs-toggle="collapse"
              data-bs-target="#navbarNavDropdown"
              aria-controls="navbarNavDropdown"
              aria-expanded="false"
              aria-label="Toggle navigation"
            >
              <span className="navbar-toggler-icon"></span>
            </button>
            <div className="collapse navbar-collapse" id="navbarNavDropdown">
              <ul className="navbar-nav">
                {signedIn && (
                  <li className="nav-item">
                    <Link
                      className="nav-link"
                      to={isAdmin ? "/adminpanel" : "/home"}
                    >
                      Home
                    </Link>
                  </li>
                )}
                {/* <li className="nav-item dropdown">
          <a className="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
           City
          </a>
          <ul className="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
            <li><a className="dropdown-item" href="#">Action</a></li>
            <li><a className="dropdown-item" href="#">Another action</a></li>
            <li><a className="dropdown-item" href="#">Something else here</a></li>
          </ul>
        </li> */}

                {!signedIn && (
                  <li className="nav-item">
                    <Link className="nav-link" to="/signin">
                      Signin
                    </Link>
                  </li>
                )}
                {!signedIn && (
                  <li className="nav-item">
                    <Link className="nav-link" to="/signup">
                      Signup
                    </Link>
                  </li>
                )}
                {signedIn && (
                  <li className="nav-item">
                    <Link
                      className="nav-link"
                      to="#"
                      onClick={() => logoutUser()}
                    >
                      Logout
                    </Link>
                  </li>
                )}
              </ul>
            </div>
          </div>
        </nav>
        <div className="container">
          <Switch>
            <Route path="/home" component={Home} />
            <Route path="/signin" component={Signin} />
            <Route path="/signup" component={Signup} />
            <Route path="/adminsignin" component={AdminSignin} />
            <Route path="/adminpanel" component={AdminPanel} />
            <Route path="/forgotpassword" component={ChangePassword} />
            <Route path="/searchtrain" component={SearchTrain} />
            <Route path="/ticketform" component={TicketForm} />
            <Route path="/ticketdetails" component={TicketDetails} />
            <Route path="/feedback" component={Feedback} />
            <Route path="/thankyou" component={Thankyou} />
            <Route path="/payment" component={PaymentPage} />
            <Route path="/" component={SplashScreen} />
          </Switch>
        </div>
      </BrowserRouter>
    </div>
  );
}
export default App;
