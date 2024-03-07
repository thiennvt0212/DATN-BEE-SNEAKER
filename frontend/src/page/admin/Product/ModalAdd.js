import { useEffect, useState } from "react";
import { AdProductApi } from "../../../api/admin/AdProductApi";
import { AdBrandApi } from "../../../api/admin/AdBrandApi";
import { AdColorApi } from "../../../api/admin/AdColorApi";
import { AdShoeApi } from "../../../api/admin/AdProductApi";
// import { AdProductApi } from "../../../api/admin/AdProductApi";
// import { AdProductApi } from "../../../api/admin/AdProductApi";
// import { AdProductApi } from "../../../api/admin/AdProductApi";
import { Button, Input, Modal, Select, message } from "antd";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faMagnifyingGlass,
  faPlusMinus,
} from "@fortawesome/free-solid-svg-icons";

const ModalAdd = () => {
  // let [codeProduct, setCodeProduct] = useState("");
  // let [nameProduct, setNameProduct] = useState("");
  // let [errorCode, setErrorCode] = useState("");
  // let [errorName, setErrorName] = useState("");
  let [listBrand, setListBrand] = useState([]);
  let [listMaterial, setListMaterial] = useState([]);
  let [listSole, setListSole] = useState([]);
  let [listShoesColar, setListShoesColar] = useState([]);



  return (
    <div className="form-brand" style={{ backgroundColor: "transparent" }}>
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
            style={{
              fontSize: "30px",
              fontWeight: "bold",
              marginRight: "900px",
            }}
          >
            Thêm sản phẩm
          </div>
        </div>
        <h3 style={{ textAlign: "center", color: "#C0C0C0" }}>
          Thông tin sản phẩm
        </h3>
        <div style={{ marginTop: 30, width: "700px" }}>
          <span style={{ fontWeight: "bold", marginRight: "480px" }}>
            tên sản phẩm
          </span>
          <br></br>
          <Input
            placeholder="Nhập tên sản phẩm"
            style={{ width: 600, marginTop: "5px" }}
          />
          <br></br>
          <div>
            <span
              style={{
                marginTop: "10px",
                fontWeight: "bold",
                marginRight: "210px",
                marginLeft: "-180px",
              }}
            >
              tên sản phẩm
            </span>
            <span style={{ marginTop: "10px", fontWeight: "bold" }}>
              tên sản phẩm
            </span>
          </div>

          <Select
            defaultValue="lucy"
            style={{
              width: 295,
              marginRight: "10px",
            }}
            allowClear
            options={[
              {
                value: "jack",
                label: "Jack",
              },
              {
                value: "lucy",
                label: "Lucy",
              },
              {
                value: "Yiminghe",
                label: "yiminghe",
              },
              {
                value: "disabled",
                label: "Disabled",
                disabled: true,
              },
            ]}
          />

          <Select
            defaultValue="lucy"
            style={{
              width: 295,
            }}
            allowClear
            options={[
              {
                value: "jack",
                label: "Jack",
              },
              {
                value: "lucy",
                label: "Lucy",
              },
              {
                value: "Yiminghe",
                label: "yiminghe",
              },
              {
                value: "disabled",
                label: "Disabled",
                disabled: true,
              },
            ]}
          />
          <br></br>
          <div>
            <span
              style={{
                marginTop: "10px",
                fontWeight: "bold",
                marginRight: "210px",
                marginLeft: "-180px",
              }}
            >
              tên sản phẩm
            </span>
            <span style={{ marginTop: "10px", fontWeight: "bold" }}>
              tên sản phẩm
            </span>
          </div>

          <Select
            defaultValue="lucy"
            style={{
              width: 295,
              marginRight: "10px",
            }}
            allowClear
            options={[
              {
                value: "jack",
                label: "Jack",
              },
              {
                value: "lucy",
                label: "Lucy",
              },
              {
                value: "Yiminghe",
                label: "yiminghe",
              },
              {
                value: "disabled",
                label: "Disabled",
                disabled: true,
              },
            ]}
          />

          <Select
            defaultValue="lucy"
            style={{
              width: 295,
            }}
            allowClear
            options={[
              {
                value: "jack",
                label: "Jack",
              },
              {
                value: "lucy",
                label: "Lucy",
              },
              {
                value: "Yiminghe",
                label: "yiminghe",
              },
              {
                value: "disabled",
                label: "Disabled",
                disabled: true,
              },
            ]}
          />
          <Input
            placeholder="Nhập tên sản phẩm"
            style={{ width: 600, height: "100px", marginTop: "5px" }}
          />
        </div>
      </div>
    </div>
  );
};
export default ModalAdd;
