import axios from 'axios'
import { useState, useEffect } from 'react'
import { Link, useHistory } from 'react-router-dom'
import { url } from '../common/constants'


const AddRoute = () => {
    const [id, setId] = useState('')
    const [sourceid, setSourceid] = useState('')
    const [destinationid, setDestinationid] = useState('')
  
    const history = useHistory()
  
    // useEffect(() => {
    //   getRoutes()
    // }, [])
  
    // const getRoutes = () => {
    //   axios.get(url + '/admin/adminpanel/route').then((response) => {
    //     const result = response.data
    //     if (result.status === 'success') {
    //       if (result.data.length > 0) {
    //         // select the first artist from the list
    //         // select the default artist
    //         // setRoute(result.data[0].id)
    //         setRoutess(result.data)
    //       }
    //     } else {
    //       alert('error while loading list of routes')
    //     }
    //   })
    // }
  
    const addRouteToDB = () => {
      if (id.length === 0) {
        alert('enter roputeid')
      } else if (sourceid.length === 0) {
        alert('enter sourceid')
      } else if (destinationid.length === 0) {
        alert('enter destinationid')
      } else {
        const data = new FormData()
        data.append('id', id)
        data.append('sourceid', sourceid)
        data.append('destinationid', destinationid)
  
        // send the album info to the API
        axios.post(url + '/admin/adminpanel/route', data).then((response) => {
          const result = response.data
          if (result.status === 'success') {
            alert('successfully added new Route')
            history.push('/routes')
          } else {
            console.log(result.error)
            alert('error while loading Routes')
          }
        })
      }
    }
  
    return (
      <div>
        <h1 className="page-title">Add Route</h1>
  
        <div className="mb-3">
          <label htmlFor="">RouteId</label>
          <input
            onChange={(e) => {
                setId(e.target.value)
            }}
            type="text"
            className="form-control"
          />
        </div>
        <div className="mb-3">
          <label htmlFor="">Sourceid</label>
          <input
            onChange={(e) => {
                setSourceid(e.target.value)
            }}
            type="text"
            className="form-control"
          />
        </div>
  
        <div className="mb-3">
          <label htmlFor="">Destinationid</label>
          <input
            onChange={(e) => {
                setDestinationid(e.target.value)
            }}
            type="text"
            className="form-control">
            </input>
          
        </div>
        <div className="mb-3">
          <button onClick={addRouteToDB} className="btn btn-success">
            Add
          </button>
  
          <Link to="/route">
            <a className="btn btn-warning">Back</a>
          </Link>
        </div>
      </div>
    )
  }
  
  export default AddRoute
  