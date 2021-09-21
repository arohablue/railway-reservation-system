import TrainRow from "../components/TrainRow";

const SearchedTrains = ({ trains }) => {
  console.log(
    "🚀 ~ file: SearchedTrains.js ~ line 8 ~ SearchedTrains ~ trains",
    trains
  );
  // maintain the state

  // do something automatically
  // []:
  // - accepts a variable and keeps watching the change
  // - when the variable state changes, the function (1st param) gets called
  // - keep the second param empty to execute something when the component gets loaded

  return (
    <div className="form-control">
      <h1 className="page-title">Book Train</h1>
      <table className="table table-striped">
        <thead>
          <tr>
            <th>Number</th>
            <th>Name</th>
            <th>Type</th>
            <th>Seats Gen</th>
            <th>Seats AC</th>
            <th>Departure Date</th>
            <th>Arrival Date</th>
            <th>Source Station</th>
            <th>Destination Station</th>
            <th>General Fair</th>
            <th>Ac Fair</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {trains.length === 0 ? (
            <h1>No Trains</h1>
          ) : (
            trains.length !== 0 &&
            trains !== undefined &&
            trains.map((train) => {
              return <TrainRow train={train} />;
            })
          )}
        </tbody>
      </table>
      <img src="train.svg" />
    </div>
  );
};

export default SearchedTrains;
