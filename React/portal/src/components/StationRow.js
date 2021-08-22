import { useHistory } from 'react-router-dom'

const StationRow = ({station}) => {
    const history = useHistory()


    return (
      <tr>
        <td>{station.id}</td>
        <td>{station.stationname}</td>
        <td>
         
          <button
            onClick={() => {
              // /add-songs-to-album -> path of the component
              // {album: album}      -> data needed to be passed to the component
              history.push('/signin', { station: station })
            }}
            className="btn btn-warning btn-sm">
            Edit
          </button>
          {/* <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>  */}
          <button
            onClick={() => {
              // /add-songs-to-album -> path of the component
              // {album: album}      -> data needed to be passed to the component
              history.push('/signin', { station: station })
            }}
            className="btn btn-danger btn-sm ">
            Delete
          </button>
          
        </td>
      </tr>
    )
}
  
export default StationRow