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
function getItem(label, key, icon, children, type) {
  return {
    key,
    children,
    label,
    type,
  };
}
const items = [
  getItem("Quản lý sản phẩm", "sub1", <MailOutlined />, [
    getItem(
      <Link to="/Product" element={<Product />}>
        {" "}
        <h4 style={{ color: "#C0C0C0", marginRight: "40px" }}>Product</h4>
      </Link>
    ),
    getItem(
      <Link to="/brand" element={<Brand />}>
        {" "}
        <h4 style={{ color: "#C0C0C0", marginRight: "40px" }}>Brand</h4>
      </Link>
    ),
    getItem(
      <Link to="/color" element={<Color />}>
        {" "}
        <h4 style={{ color: "#C0C0C0", marginRight: "40px" }}>Color</h4>
      </Link>
    ),
    getItem(
      <Link to="/size" element={<Size />}>
        {" "}
        <h4 style={{ color: "#C0C0C0", marginRight: "40px" }}>Size</h4>
      </Link>
    ),
    getItem(
      <Link to="/material" element={<Material />}>
        {" "}
        <h4 style={{ color: "#C0C0C0", marginRight: "40px" }}>Material</h4>
      </Link>
    ),
    getItem(
      <Link to="/sole" element={<Sole />}>
        {" "}
        <h4 style={{ color: "#C0C0C0", marginRight: "40px" }}>Sole</h4>
      </Link>
    ),
    getItem(
      <Link to="/shoesColar" element={<ShoesColar />}>
        {" "}
        <h4 style={{ color: "#C0C0C0", marginRight: "40px" }}>Shoes colar</h4>
      </Link>
    ),
  ]),
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
            overflow: "auto",
            position: "fixed",
            left: 0,
            height: "100%",
            top: 0,
            backgroundColor: 'white',
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
