import {
  faArrowUp,
  faCalendarDay,
  faEye,
  faFilter,
  faMagnifyingGlass,
  faMagnifyingGlassArrowRight,
  faMagnifyingGlassChart,
  faMagnifyingGlassDollar,
  faMagnifyingGlassLocation,
  faMagnifyingGlassPlus,
  faPen,
  faPlusMinus,
  faTrashCan,
} from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { Button, Input, Pagination, Radio, Space, Table, message } from "antd";
import { useEffect, useState } from "react";
import { AdSoleApi } from "../../../api/admin/AdSoleApi";
import ModalDetail from "./ModalDetail";
import ModalAdd from "./ModalAdd";

function Sole() {
  let [listSole, setListSole] = useState([]);
  let [current, setCurrent] = useState(1);
  let [totalPages, setTotalPages] = useState(0);
  let [findSole, setFindSole] = useState("");

  useEffect(() => {
    loadData();
  }, [current]);

  const loadData = () => {
    let filter = {
      value: findSole,
      page: current - 1,
    };
    AdSoleApi.getpage(filter)
      .then((response) => {
        setListSole(response.data.data);
        console.log(response.data.data);
        setTotalPages(response.data.totalPages);
      })
      .catch((error) => {
        console.error(error);
      });
  };

  const handleDelete = (id) => {
    AdSoleApi.handelDelete(id)
      .then((res) => {
        const newState = listSole.filter((item) => item.id !== id);
        setListSole(newState);
        message.success("Xoá thành công!");
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
      title: "Mã thương hiệu",
      dataIndex: "code",
      key: "code",
    },
    {
      title: "Tên thương hiệu",
      dataIndex: "name",
      key: "name",
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
            onClick={() => handleDelete(record.id)}
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
    <div className="form-Sole" style={{ backgroundColor: "transparent" }}>
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
            Thương hiệu
          </div>
        </div>
        <div style={{ marginTop: 30, marginRight:"640px"}}>
          <Input
            className="input-search"
            style={{
              width: "350px",
              height: "35px",
              // right: 330,
              marginRight: "20px",
            }}
            placeholder="Nhập tên thương hiệu cần tìm..."
            value={findSole}
            onChange={(e) => setFindSole(e.target.value)}
          />
          <FontAwesomeIcon
            icon={faMagnifyingGlass}
            onClick={loadData}
            style={{ height: "25px"}}
          />

          <Button style={{ left: 620 }} onClick={openModalAdd}>
            <FontAwesomeIcon icon={faPlusMinus}></FontAwesomeIcon>
            <span
              style={{
                color: "#C0C0C0",
                marginLeft: "20px",
              }}
            >
              Thêm mới
            </span>
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
          className="tableSole"
          dataSource={listSole}
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

      <ModalAdd
        visible={visibleModalAdd}
        onCancel={cancelModalAdd}
        fetchAll={loadData}
      />
    </div>
  );
}
export default Sole;
