import { BrowserRouter, Link, Route, Switch } from 'react-router-dom'
import Station from './Station';
import Routess from './Routess';
import Users from './Users';
import Trains from './Trains';
import AddRoute from './AddRoute';
import AddTrain from './AddTrain';
import AddStation from './AddStation';

const AdminPanel = () => {
   
        return (
          <div>
            <BrowserRouter>    
            <nav className="navbar navbar-expand-lg navbar-light bg-light">
        <div className="container-fluid">
          <a className="navbar-brand" href="#">Admin Panel Home</a>
          <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className="collapse navbar-collapse" id="navbarNavDropdown">
            <ul className="navbar-nav">
              <li className="nav-item">
              <Link className="nav-link" to="/home"> Admin Panel</Link> 
              </li>
              
           
            <li className="nav-item">
              <Link className="nav-link" to="/station"> Stations</Link> 
              </li>
              <li className="nav-item">
              <Link className="nav-link" to="/routes"> Routes</Link> 
              </li>
              <li className="nav-item">
              <Link className="nav-link" to="/train"> Trains</Link> 
              </li>
              <li className="nav-item">
              <Link className="nav-link" to="/user"> Users</Link> 
              </li>
              </ul>
          </div>
        </div>
      </nav>
              <div className="container">
                <Switch>
                  <Route path="/station" component={Station} />
                  <Route path="/routes" component={Routess} />
                  <Route path="/train" component={Trains} />
                  <Route path="/user" component={Users} />
                  <Route path="/add-route" component={AddRoute} />
                  <Route path="/add-train" component={AddTrain} />
                  <Route path="/add-station" component={AddStation} />
                 
                 
                </Switch>
              </div>
            </BrowserRouter>
          </div>
        )
      }
  
  
  export default AdminPanel