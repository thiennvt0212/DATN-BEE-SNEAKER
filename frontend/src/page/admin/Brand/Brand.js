import {
  faArrowUp,
  faCalendarDay,
  faFilter,
  faPen,
  faPlusMinus,
  faTrashCan,
} from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { Input, Space, Table } from "antd";
import { useEffect, useState } from "react";
import { AdBrandAPI } from "../../../api/admin/AdBrandApi";
import ModalDetail from "./ModalDetail"

function Brand() {
  let [listBrand, setListBrand] = useState([]);
  let [current, setCurrent] = useState(1);

  useEffect(() => {
    loadData();
  }, []);
  const loadData = () => {
    AdBrandAPI.getAll()
      .then((response) => {
        setListBrand(response.data);
        console.log(listBrand);
      })
      .catch((error) => {
        console.error(error);
      });
  };

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
      title: "Code brand",
      dataIndex: "code",
      key: "code",
    },
    {
      title: "Name brand",
      dataIndex: "name",
      key: "name",
    },
    {
      title: "Action",
      dataIndex: "action",
      key: "action",
      render: (text, record) => (
        <Space>
          <FontAwesomeIcon
            icon={faCalendarDay}
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

          <FontAwesomeIcon
            icon={faPen}
            onClick={() => {
              // openModalUpdate(record.id);
            }}
            style={{ padding: 15, fontSize: "20px" }}
          ></FontAwesomeIcon>
        </Space>
      ),
    },
  ];

  const [visibleModalDetail, setVisibleModalDetail] = useState(false);
  const [idSelected, setIdSelected] = useState(null);

  const openModalDetail = (id) => {
    setIdSelected(id);
    setVisibleModalDetail(true);
  };
  const cancelModalDetail = () => {
    setIdSelected(null);
    setVisibleModalDetail(false);
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
            Brand
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
          dataSource={listBrand}
          rowKey="id"
          columns={columns}
          pagination={false}
        />
      </div>
      <ModalDetail
        visible={visibleModalDetail}
        onCancel={cancelModalDetail}
        id={idSelected}
      />
    </div>
  );
}
export default Brand;
