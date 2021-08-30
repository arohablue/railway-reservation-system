import axios from "axios";
import { useState, useEffect } from "react";
import { Link, useHistory } from "react-router-dom";
import { url } from "../common/constants";
import SearchedTrains from "./SearchedTrains";

import DatePicker from "react-date-picker";

const SearchTrain = () => {
  const [source, setSource] = useState([]);
  const [trainsSearched, setTrainsSerched] = useState([]);
  const [sourceStations, setSourceStations] = useState([]);
  const [destinationStations, setDestinationStations] = useState([]);
  const [destination, setDestination] = useState([]);
  const [date, setDate] = useState(new Date());
  const [trainsList, setTrainsList] = useState(new Date());
  // const [tclass, setTclass] = useState([])

  useEffect(() => {
    setTrainsSerched(true);
    getSourcesStations();
    getDestinationStations();
  }, []);

  const history = useHistory();

  const getSourcesStations = () => {
    axios.get(url + "/train/getsourcestations").then((response) => {
      console.log(response);
      const result = response.data;
      console.log("Source Stations:" + response.data);
      if (result.status === "success") {
        setSourceStations(result.data);
      } else {
        alert("error while loading list of Source Stations");
      }
    });
  };

  const getDestinationStations = () => {
    axios.get(url + "/train/getdestinationstations").then((response) => {
      const result = response.data;
      console.log("Destination Stations:" + response.data);
      if (result.status === "success") {
        setDestinationStations(result.data);
      } else {
        alert("error while loading list of destination Stations");
      }
    });
  };

  const searchTrain = () => {
    if (source.length === 0) {
      alert("enter Source name");
    } else {
      if (destination.length === 0) {
        alert("enter Destination name");
      } else {
        if (date.length === 0) {
          alert("select Date");
        } else if (source === destination) {
          alert("source and destination cannot be same");
        } else {
          const data = {};

          // send the album info to the API
          axios
            .post(url + "/admin/adminpanel/addstation", data)
            .then((response) => {
              const result = response.data;
              if (result.status === "success") {
                setTrainsList();
                history.push("/searchtrains");
              } else {
                console.log(result.error);
                alert("error while searching Train Station");
              }
            });
        }
      }
    }
  };

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
      {trainsSearched ? (
        // <SearchedTrains trains={trainsList} />
        ""
      ) : (
        <div>
          {" "}
          <h2 className="page-title">Search Train</h2>
          <div className="mb-3">
            <label htmlFor="">From</label>
            <select
              onChange={(e) => {
                setSource(e.target.value);
              }}
              className="form-control"
            >
              {sourceStations.map((station) => {
                return (
                  <option value={station.stationId}>
                    {station.stationName}
                  </option>
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
              {destinationStations.map((station) => {
                return (
                  <option value={station.stationId}>
                    {station.stationName}
                  </option>
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
            <button onClick={searchTrain} className="btn btn-success">
              Add
            </button>

            <Link to="/trainDetails">
              <a className="btn btn-warning">Back</a>
            </Link>
          </div>
        </div>
      )}
    </div>
  );
};

export default SearchTrain;
