import { faFilter } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { Input, Table } from "antd";
import { useEffect, useState, useRef } from "react";
import { AdColorAPI } from "../../../api/admin/AdColorApi";
import '@fortawesome/fontawesome-free/css/all.css';
import {FormDialog} from "./Dialog";

function Color() {
  let [listColor, setListColor] = useState([]);
  const [isFormOpen, setIsFormOpen] = useState(false);
  const codeInput = useRef(null);

  const nameInput = useRef(null);



  useEffect(() => {
    loadDataTable();
  }, []);

  const loadDataTable = () => {
    AdColorAPI.getAll().then((response) => {
      let data = response.data.toSorted((a, b) => {
        var dateA = new Date(a.createdDate * 1000);
        var dateB = new Date(b.createdDate * 1000);
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

  const addItem = (data) => {
    var res = AdColorAPI.add(data);
    listColor.unshift(res);
  };

  const openAddColor = () => {
    setIsFormOpen(true);
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
    // event.preventDefault();
  
    // // Lấy giá trị từ các trường input
    // const codeValue = codeInput.current.value;
    // const nameValue = nameInput.current.value;
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


          <FormDialog onSubmit={handleFormSubmit}></FormDialog>

          {isFormOpen && (
            <div className="your-form-style">
              {/* Các trường mã và tên */}
              <label>Mã:</label>
              <input type="text" ref={codeInput}/>

              <label>Tên:</label>
              <input type="text" ref={nameInput} />
              <button onClick={handleFormSubmit} type="submit">Thêm</button>

              {/* Nút đóng cửa sổ form */}
              <button onClick={closeAddColor}>Đóng</button>
            </div>
          )}


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