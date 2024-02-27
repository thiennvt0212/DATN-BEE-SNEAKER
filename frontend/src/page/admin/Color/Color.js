import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { Input, Table, message, Space } from "antd";
import { useEffect, useState, useRef } from "react";
import { AdColorAPI } from "../../../api/admin/AdColorApi";
import '@fortawesome/fontawesome-free/css/all.css';
import { FormDialog } from "./Dialog";
import { FormDuDialog } from "./DetailUp";
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

function Color() {
  let [listColor, setListColor] = useState([]);
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
    AdColorAPI.getAll().then((response) => {
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

      setListColor(data);
    })
      .catch((error) => {
        console.error(error);
      })
  };


  const handleDetailIconClick = (id, code, name) => {
    console.log("okkkk");
    AdColorAPI.update(id, { code: code, name: name }).then((data) => {
      message.success("sua thanh cong");
      loadDataTable(data)
    })
  };
  
//   const handleDetailIconClick = (id, code, name) => {
//     console.log("okkkk");
//     AdColorAPI.update(id, { code: code, name: name })
//         .then((data) => {
//             message.success("Sửa thành công");
//             // Update the list with the new data
//             updateListColor(data);
//             // Close the form
//             setIsFormOpen(false);
//         })
//         .catch((error) => {
//             console.error(error);
//         });
// };

// const updateListColor = (updatedData) => {
//     // Find the index of the updated item in the list
//     const updatedIndex = listColor.findIndex((item) => item.id === updatedData.id);

//     // If the item is found, remove it from its current position
//     if (updatedIndex !== -1) {
//         listColor.splice(updatedIndex, 1);
//     }

//     // Add the updated item to the beginning of the list
//     listColor.unshift(updatedData);

//     // Set the updated list to the state
//     setListColor([...listColor]);
// };

  const handleDelete = (id) => {
    AdColorAPI.handelDelete(id)
      .then((res) => {
        const newState = listColor.filter((item) => item.id !== id);
        setListColor(newState);
        message.success("Xoá thành công!");
      })
      .catch((error) => {
        console.error(error);
      });
  };

  const addItem = (data) => {
    var res = AdColorAPI.add(data);
    listColor.unshift(res);
    loadDataTable(res);
    message.success("Thêm thành công!");

  };

  // Hàm đóng cửa sổ form
  const closeAddColor = () => {
    setIsFormOpen(false);
  };
  // const handleFormSubmit = (event) => {
  //   event.preventDefault();

  //   // Lấy giá trị từ các trường input
  //   const codeValue = event.target.elements.code.value;
  //   const nameValue = event.target.elements.name.value;

  //   // Kiểm tra validate
  //   if (!codeValue.trim() || !nameValue.trim()) {
  //     // Hiển thị thông báo lỗi hoặc thực hiện các hành động khác tùy thuộc vào yêu cầu của bạn
  //     alert('Vui lòng nhập đầy đủ mã và tên');
  //     return; // Ngăn chặn xử lý tiếp theo nếu có lỗi validate
  //   }

  //   // Xử lý logic khi submit form (ví dụ: gọi API, lưu vào cơ sở dữ liệu, ...)
  //   // Đóng form sau khi xử lý
  //   closeAddColor();
  // };
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
    // Xử lý logic khi submit form (ví dụ: gọi API, lưu vào cơ sở dữ liệu, ...)
    // Đóng form sau khi xử lý
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


          {/* <FontAwesomeIcon
            icon={faEye}
            onClick={() => handleDetailIconClick(record.id)}
            style={{ padding: 15, fontSize: "20px", color: "black" ,cursor: "pointer" }}
          /> */}
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
          dataSource={listColor}
          rowKey="id"
          columns={columns}
          pagination={false}
        />
      </div>
    </div>

  );
}
export default Color;