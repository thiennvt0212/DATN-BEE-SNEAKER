import { faFilter, faPlusMinus } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { Input,Table } from "antd";
import { useEffect, useState } from "react";
import { AdMaterialAPI } from "../../../api/admin/AdMaterialApi";

function Material(){
    let [listMaterial ,setListMaterial] = useState([]);

    const loadDataTable = () => {
      AdMaterialAPI.getAll().then((response) => {
        setListMaterial(response.data);
        console.log(listMaterial);
      }).catch((err) => {
        console.error(err);
      });
    };

    useEffect(() =>{
      loadDataTable();
    },[])

      const columns = [
        {
          title: (
            <span>
              <div style={{ display: "flex" }}>
                <span>STT</span>
              </div>
            </span>
          ),
          dataIndex: "stt",
          render: (text, record, index) => <span>{index + 1}</span>,
         },
         {
          title: "Code Color",
          dataIndex: "code",
          key: "code",
        },
        {
          title: "Name Color",
          dataIndex: "name",
          key: "name",
        },]
    
    return(
        <div className="form-material" style={{ backgroundColor: "transparent" }}>
        <div className="form-search">
          <div
            style={{
              borderBottom: "1px solid gray",
              padding: 10,
              marginLeft: 20,
              marginRight: 20,
            }}
          >
            <div
              style={{ fontSize: "30px", fontWeight: "bold", marginRight: 1100 }}
            >
              Material
            </div>
          </div>
          <div style={{ marginTop: 30 }}>
            <Input
              style={{ width: "250px", marginLeft: "50px", marginRight: "20px" }}
              // value={findBrand}
              // onChange={(e) => setFindBrand(e.target.value)}
            />
            <FontAwesomeIcon
              icon={faFilter}
              // onClick={loadData}
              style={{ height: "25px", marginLeft: "10px" }}
            />
  
            <FontAwesomeIcon
              icon={faPlusMinus}
              style={{ height: "25px", marginLeft: "20px" }}
              // onClick={openModalAdd}
            ></FontAwesomeIcon>
          </div>
        </div>
        <div
          style={{
            marginTop: 25,
            backgroundColor: "white",
            padding: 20,
            borderRadius: "5px",
          }}
        >
             <Table
          className="tableBrand"
          dataSource={listMaterial}
          rowKey="id"
          columns={columns}
          pagination={false}
        />
        </div>
      </div>
    );
}
export default Material;