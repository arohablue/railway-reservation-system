import axios from "axios";
import { useState, useEffect } from "react";
import { Link, useHistory } from "react-router-dom";
import { url } from "../common/constants";
import SearchedTrains from "./SearchedTrains";

import DatePicker from "react-date-picker";

const SearchTrain = () => {
  const [source, setSource] = useState("");
  const [trainsSearched, setTrainsSearched] = useState([]);
  const [sourceStations, setSourceStations] = useState([]);
  const [destinationStations, setDestinationStations] = useState([]);
  const [destination, setDestination] = useState("");
  const [date, setDate] = useState(new Date());
  const [trainsList, setTrainsList] = useState([]);

  useEffect(() => {
    setTrainsSearched(false);
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
      alert("Enter From Station");
    } else {
      if (destination.length === 0) {
        alert("enter To Station");
      } else {
        if (date.length === 0) {
          alert("select Date");
        } else if (source === destination) {
          alert("From and To cannot be same");
        } else {
          const data = {
            fromStation: {
              stationId: source,
            },
            toStation: {
              stationId: destination,
            },
            journeyDate: date,
            coachClass: "AC",
          };

          // send the album info to the API
          axios.post(url + "/user/searchtrain", data).then((response) => {
            const result = response.data;
            console.log("trains:" + response.data);
            if (result.status === "success") {
              setTrainsList(result.data);
              setTrainsSearched(true);
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
        <SearchedTrains trains={trainsList} />
      ) : (
        <div className="row container-center">
          {" "}
          <h2 className="page-title">Search Train</h2>
          <div className="mb-3 col-md-3">
            <label className="label-bold" htmlFor="">
              From
            </label>
            <select
              value={source}
              onChange={(e) => {
                setSource(e.target.value);
              }}
              className="form-control"
            >
              <option value="">Select station</option>
              {sourceStations.map((station) => {
                return (
                  <option value={station.stationId}>
                    {station.stationName}
                  </option>
                );
              })}
            </select>
          </div>
          <div className="mb-3 col-md-3">
            <label className="label-bold" htmlFor="">
              To
            </label>

            <select
              value={destination}
              onChange={(e) => {
                setDestination(e.target.value);
              }}
              className="form-control"
            >
              <option value="">Select station</option>
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
        <label className="label-bold" htmlFor="">Class</label>
        
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
          <div className="row container-center">
            <div className="mb-3 col-md-3">
              <button onClick={searchTrain} className="btn btn-success">
                Search
              </button>
            </div>
            <div className="mb-3 col-md-3">
              <label className="label-bold" htmlFor="">
                Date
              </label>
              <DatePicker onChange={setDate} value={date} />
            </div>
          </div>
          <div>
            <img src="search.svg" />
          </div>
        </div>
      )}
    </div>
  );
};

export default SearchTrain;
