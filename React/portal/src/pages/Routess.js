import axios from 'axios'
import { useState, useEffect } from 'react'
import { Link } from 'react-router-dom'
import { url } from '../common/constants'
import RouteRow from './../components/RouteRow';

const Routess = () => {
  const [routess, setRoutess] = useState([])

  useEffect(() => {
    console.log(`Route Component got loaded`)
    getRoutess()
  }, [])

  const getRoutess = () => {
    axios.get(url + '/admin/adminpanel/route').then((response) => {
      const result = response.data
      //
      // setUsers(result.data)
      alert("successful Route list created")
      if (result.status === 'success') {
        setRoutess(result.data)
      } else {
        alert('error while loading list of Route')
      }
    })
  }


  return (
    <div className="form-control">
      <h1 className="page-title">Routes</h1>

      



      <Link to="/add-route">
        <a className="btn btn-success">Add Route</a>
      </Link>
      <table className="table table-striped">
        <thead>
          <tr>
            <th>routeid</th>
            <th>sourceid</th>
            <th>destinationid</th>
          </tr>
        </thead>
        <tbody>
          {routess.map((route) => {
            return <RouteRow route={route} />
          })}
        </tbody>
      </table>
    </div>
  )
}
  
  export default Routess