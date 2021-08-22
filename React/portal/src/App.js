import logo from './logo.svg';
import './App.css'
import { BrowserRouter, Link, Route, Switch } from 'react-router-dom'
import Home from './pages/Home'
import Signin from './pages/Signin'
import Signup from './pages/Signup';
// import AddUser from './pages/AddUser';
import AdminSignin from './pages/AdminSignin';
import AdminPanel from './pages/AdminPanel';
import ChangePassword from './pages/ChangePassword';
import SearchTrain from './pages/SearchTrain';



function App() {
  return (
    <div>
      <BrowserRouter>   
     
      <nav className="navbar navbar-expand-lg navbar-light bg-light">
  <div className="container-fluid">
    <a className="navbar-brand" href="#">Railway Reservation System</a>
    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
      <span className="navbar-toggler-icon"></span>
    </button>
    <div className="collapse navbar-collapse" id="navbarNavDropdown">
      <ul className="navbar-nav">
        <li className="nav-item">
        <Link className="nav-link" to="/home"> Home</Link> 
        </li>
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
     
      <li className="nav-item">
        <Link className="nav-link" to="/signin"> Signin</Link> 
        </li>
        <li className="nav-item">
        <Link className="nav-link" to="/signup"> Signup</Link> 
        </li>
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
            <Route path = "/Change" component={ChangePassword}/>
            <Route path = "/searchtrain" component={SearchTrain}/>
        
          </Switch>
        </div>
      </BrowserRouter>
    </div>
  )
}
export default App
