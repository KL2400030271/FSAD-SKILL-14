import { useEffect, useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

function Profile() {
  const [userData, setUserData] = useState({});
  const navigate = useNavigate();
useEffect(() => {
  const id = localStorage.getItem("userId");

  console.log("Stored ID:", id); // debug

  if (!id) {
    navigate("/");
    return;
  }

  axios
    .get(`http://localhost:8080/api/user/${id}`)
    .then(res => {
      console.log("User data:", res.data);
      setUserData(res.data);
    })
    .catch(err => {
      console.error(err);
      alert("Error fetching user");
    });
}, []);

}

export default Profile;