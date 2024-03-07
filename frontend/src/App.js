import logo from "./logo.svg";
import "./App.css";
import {
  BrowserRouter as Router,
  Route,
  Routes,
  Navigate,
} from "react-router-dom";
import { Header } from "./layout/Header";
import { Sidebar } from "./layout/Sidebar";
import Brand from "./page/admin/Brand/Brand";
import Sole from "./page/admin/Sole/Sole";
import Color from "./page/admin/Color/Color";
import Material from "./page/admin/Material/Material";
import Size from "./page/admin/Size/Size";
import Product from "./page/admin/Product/Product";
import ShoesColar from "./page/admin/Shoes colar/ShoesColar";

import ProductAdd from "./page/admin/Product/ModalAdd";

function App() {
  return (
    <div className="App">
      <Router>
        <Header></Header>
        <Sidebar></Sidebar>
        <div className="app-mid">
          <div className="form-in" style={{ backgroundColor: "transparent" }}>
            <Routes>
              <Route path="/brand" element={<Brand />} />
              <Route path="/sole" element={<Sole />} />
              <Route path="/color" element={<Color />} />
              <Route path="/material" element={<Material />} />
              <Route path="/size" element={<Size />} />
              <Route path="/product" element={<Product />} />
              <Route path="/shoesColar" element={<ShoesColar />} />
              <Route path="/product/add" element={<ProductAdd />} />
            </Routes>
          </div>
        </div>
      </Router>
    </div>
  );
}

export default App;
