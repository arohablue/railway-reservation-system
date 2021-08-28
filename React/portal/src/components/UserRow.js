import { useHistory } from "react-router-dom";

const UserRow = ({ user }) => {
  const history = useHistory();

  return (
    <tr>
      <td>{user.userId}</td>
      <td>{user.email}</td>

      <td>{user.age}</td>
      <td>{user.gender}</td>
      <td>{user.mobile}</td>
      <td>{user.state}</td>
      <td>{user.city}</td>
      <td>{user.role}</td>
      <td>
        <button
          onClick={() => {
            // /add-songs-to-album -> path of the component
            // {album: album}      -> data needed to be passed to the component
            history.push("/signin", { user: user });
          }}
          className="btn btn-danger btn-sm"
        >
          Delete
        </button>
      </td>
    </tr>
  );
};

export default UserRow;
