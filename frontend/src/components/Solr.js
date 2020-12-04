import React, { useState } from "react";
import { getDataSolrByName } from "../api";

function Solr() {
  const [dataSolr, setDataSolr] = useState("");
  const [valueName, setValueName] = useState("");

  const getFilterDataByName = async () => {
    try {
      const data = await getDataSolrByName(valueName);
      setDataSolr(data);
      setValueName("");
    } catch (error) {
      console.log("error", error);
    }
  };

  const handleChangeName = (e) => {
    setValueName(e.target.value);
  };

  return (
    <div>
      <div style={{ display: "flex", marginBottom: "10px" }}>
        <input
          style={{
            width: "20vw",
            padding: "3px 5px",
            marginRight: "2px",
            borderRadius: "5px",
          }}
          onChange={handleChangeName}
          value={valueName}
          placeholder="cari nama karyawan..."
        />
        <button
          style={{
            padding: "3px 5px",
            borderRadius: "5px",
          }}
          onClick={() => getFilterDataByName()}
        >
          Search
        </button>
      </div>
      {dataSolr.length === 0 || dataSolr === [] ? (
        <div style={{ fontSize: "10px", marginTop: "10px", fontWeight: "600" }}>
          Data Not Found...
        </div>
      ) : (
        <table border="1">
          <thead>
            <tr>
              <th>No.</th>
              <th>Nama</th>
              <th>Address</th>
            </tr>
          </thead>
          <tbody>
            {dataSolr.map((item, index) => {
              return (
                <tr key={index}>
                  <td>{index + 1}</td>
                  <td>{item.name}</td>
                  <td>{item.address}</td>
                </tr>
              );
            })}
          </tbody>
        </table>
      )}
    </div>
  );
}

export default Solr;
