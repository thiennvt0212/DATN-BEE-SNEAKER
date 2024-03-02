import logoDant from "../assets/img/Logo_datn_1.png";
import "./Sidebar.css";
import React from "react";
import { MailOutlined } from "@ant-design/icons";
import { Layout, Menu } from "antd";
import { Link } from "react-router-dom";
import Product from "../page/admin/Product/Product";
import Size from "../page/admin/Size/Size";
import Color from "../page/admin/Color/Color";
import Brand from "../page/admin/Brand/Brand";
import Material from "../page/admin/Material/Material";
import Sole from "../page/admin/Sole/Sole";
import ShoesColar from "../page/admin/Shoes colar/ShoesColar";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faBorderTopLeft,
  faChartSimple,
  faCircle,
  faCircleDollarToSlot,
  faFileLines,
  faFilterCircleDollar,
  faPlane,
  faShoePrints,
  faUsers,
} from "@fortawesome/free-solid-svg-icons";
function getItem(label, key, icon, children, type) {
  return {
    key,
    children,
    label,
    type,
  };
}
const items = [
  getItem(
    "",
    "aa",
    null,
    [
      getItem(
        <Link to="/shoesColar" element={<ShoesColar />}>
          {" "}
          <h4 style={{ color: "#C0C0C0", marginRight: "40px" }}>
            {" "}
            <FontAwesomeIcon
              icon={faCircleDollarToSlot}
              style={{ marginRight: "5px" }}
            />
            Bán hàng tại quầy
          </h4>
        </Link>
      ),
      getItem(
        <Link to="/shoesColar" element={<ShoesColar />}>
          {" "}
          <h4 style={{ color: "#C0C0C0", marginRight: "40px" }}>
            <FontAwesomeIcon
              icon={faChartSimple}
              style={{ marginRight: "5px" }}
            />
            Thống kê
          </h4>
        </Link>
      ),
    ],
    "group"
  ),
  getItem(
    <>
      {/* <FontAwesomeIcon icon={faShoePrints} /> */}
      <h4 style={{ color: "#C0C0C0", marginRight: "40px" }}>
        <FontAwesomeIcon icon={faShoePrints} style={{ marginRight: "5px" }} />
        Quản lý sản phẩm
      </h4>
    </>,
    "sub1",
    <MailOutlined />,
    [
      getItem(
        <Link to="/Product" element={<Product />}>
          {" "}
          <h4 style={{ color: "#C0C0C0", marginRight: "40px" }}>Sản phẩm</h4>
        </Link>
      ),
      getItem(
        <Link to="/brand" element={<Brand />}>
          {" "}
          <h4 style={{ color: "#C0C0C0", marginRight: "40px" }}>Thương hiệu</h4>
        </Link>
      ),
      getItem(
        <Link to="/color" element={<Color />}>
          {" "}
          <h4 style={{ color: "#C0C0C0", marginRight: "40px" }}>Màu sắc</h4>
        </Link>
      ),
      getItem(
        <Link to="/size" element={<Size />}>
          {" "}
          <h4 style={{ color: "#C0C0C0", marginRight: "40px" }}>Kích cỡ</h4>
        </Link>
      ),
      getItem(
        <Link to="/material" element={<Material />}>
          {" "}
          <h4 style={{ color: "#C0C0C0", marginRight: "40px" }}>Chất liệu</h4>
        </Link>
      ),
      getItem(
        <Link to="/sole" element={<Sole />}>
          {" "}
          <h4 style={{ color: "#C0C0C0", marginRight: "40px" }}>Đế giày</h4>
        </Link>
      ),
      getItem(
        <Link to="/shoesColar" element={<ShoesColar />}>
          {" "}
          <h4 style={{ color: "#C0C0C0", marginRight: "40px" }}>Cổ giày</h4>
        </Link>
      ),
    ]
  ),
  getItem(
    "",
    "",
    null,
    [
      getItem(
        <Link to="/shoesColar" element={<ShoesColar />}>
          {" "}
          <h4 style={{ color: "#C0C0C0", marginRight: "40px" }}>
            {" "}
            <FontAwesomeIcon icon={faUsers} style={{ marginRight: "5px" }} />
            Tài khoản
          </h4>
        </Link>
      ),
      getItem(
        <Link to="/shoesColar" element={<ShoesColar />}>
          {" "}
          <h4 style={{ color: "#C0C0C0", marginRight: "40px" }}>
            <FontAwesomeIcon
              icon={faFileLines}
              style={{ marginRight: "5px" }}
            />
            Quản lý đơn hàng
          </h4>
        </Link>
      ),
    ],
    "group"
  ),
];
export function Sidebar() {
  const onClick = (e) => {
    console.log("click ", e);
  };
  return (
    <div className="sidebar" style={{ backgroundColor: "yellow" }}>
      <div className="inner">
        <Layout.Sider
          trigger={null}
          collapsible
          theme="light"
          className="sidebar"
          width={260}
          style={{
            boxShadow: "3px 7px 3px #CCCCCC",
            overflow: "auto",
            position: "fixed",
            left: 0,
            height: "100%",
            top: 0,
            backgroundColor: "white",
          }}
        >
          <img className="logo" width="100" src={logoDant} alt="ảnh logo" />
          <Menu
            className="menu"
            onClick={onClick}
            style={{
              width: 256,
            }}
            defaultSelectedKeys={["1"]}
            defaultOpenKeys={["sub1"]}
            mode="inline"
            items={items}
          />
        </Layout.Sider>
      </div>
    </div>
  );
}
