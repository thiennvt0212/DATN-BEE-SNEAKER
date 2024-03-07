import {
  faEye,
  faFilter,
  faMagnifyingGlass,
  faPlusMinus,
  faTrashCan,
} from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { Button, Input, Pagination, Space, Table, message } from "antd";
import { useEffect, useState, useSyncExternalStore } from "react";
import { AdProductDetailApi } from "../../../api/admin/AdProductDetailApi";
import ModalAdd from "./ModalAdd";
import ModalDetail from "./ModalDetail";
import { Link } from "react-router-dom";

function Product() {
  let [listProductDetail, setListProductDetail] = useState([]);
  let [current, setCurrent] = useState(1);
  let [totalPages, setTotalPages] = useState(0);
  let [findProduct, setFindProduct] = useState("");

  useEffect(() => {
    loadData();
  }, []);

  const loadData = () => {
    // let filter = {
    //   value: findProduct,
    //   page: current - 1,
    // };
    AdProductDetailApi.getAll()
      .then((response) => {
        setListProductDetail(response.data);
        console.log("đây là đata" + response.data);
        // setTotalPages(response.data.totalPages);
      })
      .catch((error) => {
        console.error(error);
      });
  };

  // const handleDelete = (id) => {
  //   AdProductApi.handelDelete(id)
  //     .then((res) => {
  //       const newState = listProduct.filter((item) => item.id !== id);
  //       setListProduct(newState);
  //       message.success("Xoá thành công!");
  //     })
  //     .catch((error) => {
  //       console.error(error);
  //     });
  // };

  const columns = [
    {
      title: (
        <span>
          <div style={{ display: "flex" }}>
            <span>STT</span>
            {/* <Space style={{ marginLeft: "40px", display: "flex" }}>
              <FontAwesomeIcon
                icon={faArrowUp}
                onClick={() => {
                  field: setField("code");
                  direction: setDirection("asc");
                  handleSortCode(field, direction);
                }}
              />
            </Space>
            <Space style={{ marginLeft: "7px", display: "flex" }}>
              <FontAwesomeIcon icon={faArrowDown} />
            </Space> */}
          </div>
        </span>
      ),
      dataIndex: "stt",
      render: (text, record, index) => <span>{index + 1}</span>,
    },
    {
      title: "Tên sản phẩm",
      dataIndex: "nameProduct",
      key: "nameProduct",
    },
    {
      title: "Số lượng",
      dataIndex: "quatity",
      key: "quatity",
    },
    {
      title: "Trạng thái",
      dataIndex: "status",
      key: "status",
    },
    {
      title: "Chức năng",
      dataIndex: "action",
      key: "action",
      render: (text, record) => (
        <Space>
          <FontAwesomeIcon
            icon={faEye}
            onClick={() => {
              openModalDetail(record.id);
            }}
            style={{ marginRight: 15, fontSize: "20px" }}
          ></FontAwesomeIcon>

          <FontAwesomeIcon
            icon={faTrashCan}
            // onClick={() => handleDelete(record.id)}
            style={{ padding: 15, fontSize: "20px", color: "red" }}
          ></FontAwesomeIcon>
        </Space>
      ),
    },
  ];

  const [visibleModalDetail, setVisibleModalDetail] = useState(false);
  const [visibleModalAdd, setVisibleModalAdd] = useState(false);
  const [idSelected, setIdSelected] = useState(null);

  const openModalDetail = (id) => {
    setIdSelected(id);
    setVisibleModalDetail(true);
  };
  const cancelModalDetail = () => {
    setIdSelected(null);
    setVisibleModalDetail(false);
  };

  const openModalAdd = () => {
    setVisibleModalAdd(true);
  };
  const cancelModalAdd = () => {
    setVisibleModalAdd(false);
  };
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
            style={{ fontSize: "30px", fontWeight: "bold", marginRight: 1100 }}
          >
            Sản phẩm
          </div>
        </div>
        <div style={{ marginTop: 30, marginRight: "640px" }}>
          <Input
            className="input-search"
            style={{
              width: "350px",
              height: "35px",
              // right: 330,
              marginRight: "20px",
            }}
            placeholder="Nhập tên sản phẩm cần tìm..."
            value={findProduct}
            onChange={(e) => setFindProduct(e.target.value)}
          />
          <FontAwesomeIcon
            icon={faMagnifyingGlass}
            onClick={loadData}
            style={{ height: "25px" }}
          />

          <Button style={{ left: 620 }}>
          <Link to="/product/add">
            <FontAwesomeIcon icon={faPlusMinus}></FontAwesomeIcon>
            <span
              style={{
                color: "#C0C0C0",
                marginLeft: "20px",
              }}
            >
              Thêm mới
            </span>
          </Link>

          </Button>
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
          dataSource={listProductDetail}
          rowKey="id"
          columns={columns}
          pagination={false}
        />
        <Pagination
          style={{ marginLeft: "100px", marginTop: "50px" }}
          simple
          current={current}
          onChange={(value) => {
            setCurrent(value);
          }}
          total={totalPages * 10}
        />
      </div>
      <ModalDetail
        visible={visibleModalDetail}
        onCancel={cancelModalDetail}
        id={idSelected}
        fetchAll={loadData}
      />

    </div>
  );
}
export default Product;
