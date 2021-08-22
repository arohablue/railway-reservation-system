import { useHistory } from 'react-router-dom'

const TrainRow = ({train}) => {
    const history = useHistory()


    return (
      <tr>
        <td>{train.id}</td>
        <td>{train.trainname}</td>
        <td>{train.traintype}</td>
        <td>{train.classgen}</td>
        <td>{train.classac}</td>
        <td>{train.departuretime}</td>
        <td>{train.arrivaltime}</td>
        <td>{train.routeid}</td>
        <td>
         
          <button
            onClick={() => {
              // /add-songs-to-album -> path of the component
              // {album: album}      -> data needed to be passed to the component
              history.push('/train', { train: train })
            }}
            className="btn btn-warning btn-sm">
            Edit
          </button>
          {/* <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>  */}
          <button
            onClick={() => {
              // /add-songs-to-album -> path of the component
              // {album: album}      -> data needed to be passed to the component
              history.push('/train', { train: train })
            }}
            className="btn btn-danger btn-sm ">
            Delete
          </button>
          
        </td>
      </tr>
    )
}
  
export default TrainRow