import axios from "axios";
import React, { useState, useEffect } from "react";
import { url } from "../common/constants";
import { Bar } from "react-chartjs-2";

export default function Revenue() {
  const [totalRevenue, setTotalRevenue] = useState("0");
  const [acRevenue, setACRevenue] = useState([
    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
  ]);
  const [genRevenue, setGenRevenue] = useState([
    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
  ]);

  useEffect(() => {
    console.log("Getting Revenue");
    axios.get(url + "/admin/adminpanel/getrevenue").then((response) => {
      console.log(response.data.data);
      setACRevenue(response.data.data.acRevenue);
      setGenRevenue(response.data.data.genRevenue);
      setTotalRevenue(response.data.data.totalRevenue);
    });
  }, []);

  const data = {
    labels: [
      "JAN",
      "FEB",
      "MARCH",
      "APRIL",
      "MAY",
      "JUNE",
      "JULY",
      "AUG",
      "SEPT",
      "OCT",
      "NOV",
      "DEC",
    ],
    datasets: [
      {
        label: "AC Revenue",
        data: acRevenue,
        backgroundColor: "#ff6361",
      },
      {
        label: "Gen Revenue",
        data: genRevenue,
        backgroundColor: "#003f5c",
      },
    ],
  };

  const options = {
    scales: {
      yAxes: [
        {
          ticks: {
            beginAtZero: true,
          },
        },
      ],
    },
  };

  return (
    <>
      <div className="header">
        <h1 className="title">Total Revenue : ₹{totalRevenue}</h1>
      </div>
      <div className="white-background">
        <Bar data={data} options={options} />
      </div>
    </>
  );
}
