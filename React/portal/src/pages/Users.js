import axios from "axios";
import { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import { url } from "../common/constants";
import UserRow from "../components/UserRow";

const Users = () => {
  // maintain the state
  const [users, setUsers] = useState([]);

  // do something automatically
  // []:
  // - accepts a variable and keeps watching the change
  // - when the variable state changes, the function (1st param) gets called
  // - keep the second param empty to execute something when the component gets loaded
  useEffect(() => {
    console.log(`Users Component got loaded`);
    getUsers();
  }, []);

  const getUsers = () => {
    axios.get(url + "/admin/adminpanel/user").then((response) => {
      const result = response.data;
      console.log("Users:" + result.data);
      if (result.status === "success") {
        setUsers(result.data);
      } else {
        alert("error while loading list of albums");
      }
    });
  };

  return (
    <div className="form-control">
      <h1 className="page-title">Users</h1>

      {/* <Link to="/add-user">
        <a className="btn btn-success">Add User</a>
      </Link> */}
      <table className="table table-striped">
        <thead>
          <tr>
            <th>id</th>
            <th>Email</th>

            <th>Age</th>
            <th>Gender</th>
            <th>Mobile</th>
            <th>State</th>
            <th>City</th>
            <th>Role</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {users.map((user) => {
            return <UserRow user={user} />;
          })}
        </tbody>
      </table>
      <img className="img-background-wrapper" src="users.svg" />
    </div>
  );
};

export default Users;
