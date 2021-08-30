import axios from "axios";
import { useHistory } from "react-router-dom";
import { url } from "../common/constants";

const UserRow = ({ user }) => {
  const history = useHistory();

  const deleteUser = () => {
    axios
      .delete(url + "/admin/adminpanel/user/" + user.userId)
      .then((response) => {
        const result = response.data;
        if (result.status === "success") {
          alert("User Deleted");
        } else {
          alert("error while loading list of Train");
        }
      });
  };

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
            deleteUser();
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
