import { faFilter, faPlusMinus } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { Input } from "antd";

function Size(){
    return(
        <div className="form-sole" style={{ backgroundColor: "transparent" }}>
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
              Size
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
          
        </div>
      </div>
    );
}
export default Size;