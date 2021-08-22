import axios from 'axios'
import { useState, useEffect } from 'react'
import { Link } from 'react-router-dom'
import { url } from '../common/constants'
import TrainRow from '../components/TrainRow'

const Trains = () => {
  // maintain the state
  const [trains, setTrains] = useState([])

  // do something automatically
  // []:
  // - accepts a variable and keeps watching the change
  // - when the variable state changes, the function (1st param) gets called
  // - keep the second param empty to execute something when the component gets loaded
  useEffect(() => {
    console.log(`Train Component got loaded`)
    getTrains()
  }, [])

  const getTrains = () => {
    axios.get(url + '/admin/adminpanel/train').then((response) => {
      const result = response.data
      //
      // setUsers(result.data)
      alert("successful train list created")
      if (result.status === 'success') {
        setTrains(result.data)
      } else {
        alert('error while loading list of trains')
      }
    })
  }

  return (
    <div className="form-control">
      <h1 className="page-title">Trains</h1>

      



      { <Link to="/add-train">
        <a className="btn btn-success">Add Train</a>
      </Link> }
      <table className="table table-striped">
        <thead>
          <tr>
            <th>id</th>
            <th>trainname</th>
            <th>traintype</th>
            <th>classgen</th>
            <th>classac</th>
            <th>departuretime</th>
            <th>arrivaltime</th>
            <th>routeid</th>
          </tr>
        </thead>
        <tbody>
          {trains.map((train) => {
            return <TrainRow train={train} />
          })}
        </tbody>
      </table>
    </div>
  )
}

export default Trains
