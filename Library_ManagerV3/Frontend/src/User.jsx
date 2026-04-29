import React, { useEffect, useState } from "react";
import axios from "axios";

function User() {

  const [user, setUser] = useState(null);

  // useEffect(() => {
  //   fetch("http://localhost:8080/User/1")
  //     .then((response) => {
  //       if (!response.ok) {
  //         throw new Error("Lỗi khi gọi API");
  //       }
  //       return response.json();   // nhớ ()
  //     })
  //     .then((data) => {
  //       console.log("Data nhận được:", data);
  //       setUser(data);
  //     })
  //     .catch((error) => {
  //       console.error("Lỗi:", error);
  //     });
  // }, []); // rất quan trọng

  useEffect(()=>{
    axios
    .get("http://localhost:8080/User/1")
    .then((response) => setUser(response.data))
    .catch((error) => console.error(error))
  },[]);


  if (!user) {
    return <div>Loading...</div>;
  }

  return (
    <div>
      <h2>Thông tin User</h2>
      <p>ID: {user.Id}</p>
      <p>CCCD: {user.Cccd}</p>
      <p>Tên: {user.Name}</p>
      <p>Ngày sinh: {user.BirthDate}</p>
      <p>Địa chỉ: {user.Address}</p>
      <p>UserName: {user.UserName}</p>
      <p>Role: {user.Role}</p>
    </div>
  );
}

export default User;
