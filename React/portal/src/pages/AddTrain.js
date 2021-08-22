import axios from 'axios'
import { useState, useEffect } from 'react'
import { Link, useHistory } from 'react-router-dom'
import { url } from '../common/constants'



const AddTrain= () => {
    const [id, setId] = useState('')
    const [trainname, setTrainname] = useState('')
    const [traintype, setTraintype] = useState('')
    const [classgen, setClassgen] = useState('')
    const [classac, setClassac] = useState('')
    const [departuretime, setDeparturetime] = useState('')
    const [arrivaltime, setArrivaltime] = useState('')
    const [routeid, setRouteid] = useState('')
   
    const history = useHistory()
  
    const addTrainToDB = () => {
      if (id.length === 0) {
        alert('enter trainid')
      } else if (trainname.length === 0) {
        alert('enter trainname')
      } else if (traintype.length === 0) {
        alert('enter traintype')
    } else if (classgen.length === 0) {
        alert('enter classgen')
    } else if (classac.length === 0) {
        alert('enter classac')
    } else if (departuretime.length === 0) {
        alert('enter departuretime')
    } else if (arrivaltime.length === 0) {
        alert('enter arrivaltime')
    } else if (routeid.length === 0) {
        alert('enter routeid')
      } else {
        const data = new FormData()
        data.append('id', id)
        data.append('trainname', trainname)
        data.append('traintype', traintype)
        data.append('classgen', classgen)
        data.append('classac', classac)
        data.append('departuretime', departuretime)
        data.append('arrivaltime', arrivaltime)
        data.append('routeid', routeid)
       
  
        // send the album info to the API
        axios.post(url + '/admin/adminpanel/train', data).then((response) => {
          const result = response.data
          if (result.status === 'success') {
            alert('successfully added new Train')
            history.push('/train')
          } else {
            console.log(result.error)
            alert('error while loading Train')
          }
        })
      }
    }
  
    return (
      <div>
        <h1 className="page-title">Add Train</h1>
  
        <div className="mb-3">
          <label htmlFor="">TrainId</label>
          <input
            onChange={(e) => {
                setId(e.target.value)
            }}
            type="text"
            className="form-control"
          />
        </div>
        <div className="mb-3">
          <label htmlFor="">TrainName</label>
          <input
            onChange={(e) => {
                setTrainname(e.target.value)
            }}
            type="text"
            className="form-control"
          />
        </div>
        <div className="mb-3">
          <label htmlFor="">TrainType</label>
          <input
            onChange={(e) => {
                setTraintype(e.target.value)
            }}
            type="text"
            className="form-control"
          />
        </div>
        <div className="mb-3">
          <label htmlFor="">ClassGen</label>
          <input
            onChange={(e) => {
                setClassgen(e.target.value)
            }}
            type="text"
            className="form-control"
          />
        </div>
        <div className="mb-3">
          <label htmlFor="">ClassAC</label>
          <input
            onChange={(e) => {
                setClassac(e.target.value)
            }}
            type="text"
            className="form-control"
          />
        </div>
        <div className="mb-3">
          <label htmlFor="">Departure Time</label>
          <input
            onChange={(e) => {
                setDeparturetime(e.target.value)
            }}
            type="text"
            className="form-control"
          />
        </div>
        <div className="mb-3">
          <label htmlFor="">Arrival Time</label>
          <input
            onChange={(e) => {
                setArrivaltime(e.target.value)
            }}
            type="text"
            className="form-control"
          />
        </div>
        <div className="mb-3">
          <label htmlFor="">RouteId</label>
          <input
            onChange={(e) => {
                setRouteid(e.target.value)
            }}
            type="text"
            className="form-control"
          />
        </div>
  
       
          
      
        <div className="mb-3">
          <button onClick={addTrainToDB} className="btn btn-success">
            Add
          </button>
  
          <Link to="/train">
            <a className="btn btn-warning">Back</a>
          </Link>
        </div>
      </div>
    )
  }
  
  export default AddTrain
  