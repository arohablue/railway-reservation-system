import React from "react";
import { Bar } from "react-chartjs-2";

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
      data: [1200, 1900, 300, 500, 200, 300, 1200, 1900, 300, 500, 200, 300],
      backgroundColor: "rgb(252, 3, 3)",
    },
    {
      label: "Gen Revenue",
      data: [200, 300, 2000, 500, 100, 400, 200, 300, 2000, 500, 100, 400],
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

const Revenue = () => (
  <>
    <div className="header">
      <h1 className="title">Revenue</h1>
    </div>
    <Bar data={data} options={options} />
  </>
);

export default Revenue;
