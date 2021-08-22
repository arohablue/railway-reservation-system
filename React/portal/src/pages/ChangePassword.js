
import { useState } from 'react'
import axios from 'axios';
import { Link, useHistory } from 'react-router-dom';

const ChangePassword = () => {
  // define the state
  
  const [email, setEmail] = useState('')
 
  const [password, setPassword] = useState('')
  
  const history =useHistory();

  const changepassword = () => {
    
    console.log(`email = ${email}`)
    
    console.log(`password = ${password}`)


    if (email.length===0){
      alert('Enter You Email')
    }
    
    else if(password.length===0){
    alert('Enter New Password')
    }
    else{
      const data = new FormData()

      console.log(email)
      console.log(password)
      
      data.append('email',email);
      data.append('password',password);

      
     
      console.log(data)
      const url = 'http://localhost:8080'

      
      axios.post(url+'/user/changepassword',data).then((response)=>{
        
          const result = response.data
          alert("successful")
          
        //   if(result.status === 'success'){
        //       alert('Password Updated Sucessfully')
             
        //       history.push('/signin')

        //   }
        //   else{
        //       alert('Error While Adding Data')
        //   }
      })
    }
  }

  return (
      
      <div className="style">
      <div className="container">
      <h1>Change Your Password</h1>
      <div className="image">
      <div className="mb-3">
     
      <div className="mb-3">
        <label>Email</label>
        <input
          onChange={(event) => {
            // updating the state with user entered value
            setEmail(event.target.value)
          }}
          className="form-control"
          type="email"
          placeholder="Enter Your Email"
          
        />
      </div>

      <div className="mb-3">
        <label>New Password</label>
        <input
          onChange={(event) => {
            // updating the state with user entered value
            setPassword(event.target.value)
          }}
          className="form-control"
          type="password"
          placeholder="Enter New Password"
        />
      </div>
      <div className="mb-3">
        <button onClick={changepassword} className="btn btn-success">
          Confirm 
        </button> <Link className="nav-link" to ="/signin">Back</Link>
       
      </div>
    </div>
    </div>
    </div>
    </div>

    
  )
}

export default ChangePassword