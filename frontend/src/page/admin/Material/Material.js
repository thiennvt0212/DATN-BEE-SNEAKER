import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { Input, Table, message, Space } from "antd";
import { useEffect, useState, useRef } from "react";
import { AdColorAPI, AdMaterialAPI } from "../../../api/admin/AdMaterialApi";
import '@fortawesome/fontawesome-free/css/all.css';
import { FormDialog } from "./AddMate";
import { FormDuDialog } from "./DetailUpMa";
import {
  faArrowUp,
  faCalendarDay,
  faEye,
  faFilter,
  faPen,
  faPlusMinus,
  faTrashCan,
} from "@fortawesome/free-solid-svg-icons";
import { apiColor } from "../../../config/apiConfig";

function Material() {
  let [listMaterial, setListMaterial] = useState([]);
  const [isFormOpen, setIsFormOpen] = useState(false);
  const codeInput = useRef(null);
  const nameInput = useRef(null);
  const [selectedRecord, setSelectedRecord] = useState(null); // To store the selected record for update

  const [isUpdate, setIsUpdate] = useState(false);
  const [initialValues, setInitialValues] = useState(null);

  useEffect(() => {
    loadDataTable();
  }, []);

  const loadDataTable = () => {
    AdMaterialAPI.getAll().then((response) => {
      let data = response.data.toSorted((a, b) => {
        var dateA = new Date(a.lastModifiedDate * 1000);
        var dateB = new Date(b.lastModifiedDate * 1000);
        if (dateA < dateB) {
          return 1;
        } else if (dateA > dateB) {
          return -1;
        } else {
          return 0;
        }
      });

      setListMaterial(data);
    })
      .catch((error) => {
        console.error(error);
      })
  };

  const handleDetailIconClick = (id, code, name) => {
    console.log("okkkk");
    AdMaterialAPI.update(id, { code: code, name: name }).then((data) => {
      message.success("sua thanh cong");
      loadDataTable(data)
    })
  };

  const handleDelete = (id) => {
    AdMaterialAPI.handelDelete(id)
      .then((res) => {
        const newState = listMaterial.filter((item) => item.id !== id);
        setListMaterial(newState);
        message.success("Xoá thành công!");
      })
      .catch((error) => {
        console.error(error);
      });
  };

  const addItem = (data) => {
    var res = AdMaterialAPI.add(data);
    listMaterial.unshift(res);
    loadDataTable(res);
    message.success("Thêm thành công!");

  };

  // Hàm đóng cửa sổ form
  const closeAddColor = () => {
    setIsFormOpen(false);
  };

  const handleFormSubmit = (codeValue, nameValue) => {

    console.log(nameValue);
    // Kiểm tra validate
    if (!codeValue.trim() || !nameValue.trim()) {
      // Hiển thị thông báo lỗi hoặc thực hiện các hành động khác tùy thuộc vào yêu cầu của bạn
      alert('Vui lòng nhập đầy đủ mã và tên');
      return; // Ngăn chặn xử lý tiếp theo nếu có lỗi validate
    }
    addItem({
      code: codeValue,
      name: nameValue,
    });
    loadDataTable();
    closeAddColor();
  };


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
    },
    {
      title: "Chức năng",
      dataIndex: "action",
      key: "action",
      render: (text, record) => (
        <Space>

          <FormDuDialog
            onSubmit={handleDetailIconClick}
            data={record}
          />

          <FontAwesomeIcon
            icon={faTrashCan}
            onClick={() => handleDelete(record.id)}
            style={{ padding: 15, fontSize: "20px", color: "red" }}
          ></FontAwesomeIcon>


        </Space>
      ),
    },]


  return (

    <div className="form-color" style={{ backgroundColor: "transparent", zIndex: 999 }}>
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
            Color
          </div>
        </div>
        <div style={{ marginTop: 30 }}>

          <FormDialog onSubmit={handleFormSubmit}></FormDialog>

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