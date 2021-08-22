import axios from 'axios'
import { useState, useEffect } from 'react'
import { Link, useHistory } from 'react-router-dom'
import { url } from '../common/constants'



const AddStation= () => {
    const [id, setId] = useState('')
    const [stationname, setStationname] = useState('')
  
    const history = useHistory()
  
    const addStationToDB = () => {
      if (id.length === 0) {
        alert('enter station ID')
      } else if (stationname.length === 0) {
        alert('enter stationname')
      } else {
        const data = new FormData()
        data.append('id', id)
        data.append('stationname', stationname)
        
  
        // send the album info to the API
        axios.post(url + '/admin/adminpanel/station', data).then((response) => {
          const result = response.data
          if (result.status === 'success') {
            alert('successfully added new Station')
            history.push('/station')
          } else {
            console.log(result.error)
            alert('error while loading Station')
          }
        })
      }
    }
  
    return (
      <div>
        <h1 className="page-title">Add Station</h1>
  
        <div className="mb-3">
          <label htmlFor="">StationId</label>
          <input
            onChange={(e) => {
                setId(e.target.value)
            }}
            type="text"
            className="form-control"
          />
        </div>
        <div className="mb-3">
          <label htmlFor="">StationName</label>
          <input
            onChange={(e) => {
                setStationname(e.target.value)
            }}
            type="text"
            className="form-control"
          />
        </div>
    
          
      
        <div className="mb-3">
          <button onClick={addStationToDB} className="btn btn-success">
            Add
          </button>
  
          <Link to="/station">
            <a className="btn btn-warning">Back</a>
          </Link>
        </div>
      </div>
    )
  }
  
  export default AddStation
  