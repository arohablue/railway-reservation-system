import axios from "axios";
import React, { useState, useEffect } from "react";
import { url } from "../common/constants";
import { Bar } from "react-chartjs-2";

export default function Revenue() {
  const [acRevenue, setACRevenue] = useState([
    1200, 1900, 300, 500, 200, 300, 1200, 1900, 300, 500, 200, 300,
  ]);
  const [genRevenue, setGenRevenue] = useState([
    200, 300, 2000, 500, 100, 400, 200, 300, 2000, 500, 100, 400,
  ]);

  useEffect(() => {
    console.log("Getting Revenue");
    axios.get(url + "/admin/adminpanel/getrevenue").then((response) => {
      console.log(response.data.data);
      //setACRevenue(response.data.data.acRevenue);
      //setGenRevenue(response.data.data.genRevenue);
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
        backgroundColor: "rgb(252, 3, 3)",
      },
      {
        label: "Gen Revenue",
        data: genRevenue,
        backgroundColor: "rgb(54, 162, 235)",
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
        <h1 className="title">Revenue</h1>
      </div>
      <Bar data={data} options={options} />
    </>
  );
}
