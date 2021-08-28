import axios from "axios";
import { useState, useEffect } from "react";
import { Link, useHistory } from "react-router-dom";
import { url } from "../common/constants";

import DatePicker from "react-date-picker";

const SearchTrain = () => {
  const [source, setSource] = useState([]);
  const [destination, setDestination] = useState([]);
  const [date, setDate] = useState(new Date());
  // const [tclass, setTclass] = useState([])

  useEffect(() => {
    getSource();
    // getDestination()
    // getTclass()
  }, []);

  const getSource = () => {
    axios.get(url + "/admin/adminpanel/getallstation").then((response) => {
      const result = response.data;
      if (result.status === "success") {
        if (result.data.length > 0) {
          // select the first artist from the list
          // select the default artist
          setSource(result.data);
        }
      } else {
        alert("error while loading list of Train");
      }
    });
  };

  // const getDestination = () => {
  //   axios.get(url + '/admin/adminpanel/station').then((response) => {
  //     const result = response.data
  //     if (result.status === 'success') {
  //       if (result.data.length > 0) {
  //         // select the first artist from the list
  //         // select the default artist
  //         setDestination(result.data)
  //       }
  //     } else {
  //       alert('error while loading list of Train')
  //     }
  //   })
  // }

  // const getTclass = () => {
  //   axios.get(url + '/admin/adminpanel/station').then((response) => {
  //     const result = response.data
  //     if (result.status === 'success') {
  //       if (result.data.length > 0) {
  //         // select the first artist from the list
  //         // select the default artist
  //         setDestination(result.data)
  //       }
  //     } else {
  //       alert('error while loading list of Train')
  //     }
  //   })
  // }
  return (
    <div>
      <h2 className="page-title">Search Train</h2>
      <div className="mb-3">
        <label htmlFor="">From</label>
        <select
          // onChange={(e) => {
          //   setSource(e.target.value)
          // }}
          className="form-control"
        >
          {source.map((station) => {
            return (
              <option value={station.stationId}>{station.stationName}</option>
            );
          })}
        </select>
      </div>

      <div className="mb-3">
        <label htmlFor="">To</label>

        <select
          onChange={(e) => {
            setDestination(e.target.value);
          }}
          className="form-control"
        >
          {destination.map((station) => {
            return (
              <option value={station.stationId}>{station.stationName}</option>
            );
          })}
        </select>
      </div>

      {/* <div className="mb-3">
        <label htmlFor="">Class</label>
        
        <select
          onChange={(e) => {
            setTclaas(e.target.value)
          }}
          className="form-control">
          {destination.map((station) => {
            return (
              <option value={station.id}>
                {station.stationname} 
              </option>
            )
          })}
        </select>
      </div> */}

      <div className="mb-3">
        <label htmlFor="">Date</label>
        <DatePicker onChange={setDate} value={date} />
      </div>

      <div className="mb-3">
        <Link to="/add-details">
          <a className="btn btn-success">Search</a>
        </Link>
      </div>
    </div>
  );
};

export default SearchTrain;
