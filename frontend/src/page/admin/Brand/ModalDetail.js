import { useEffect, useState } from "react";
import { AdBrandAPI } from "../../../api/admin/AdBrandApi";
import { Button, Input, Modal, message } from "antd";

const ModalDetail = ({ visible, onCancel, fetchAll, id }) => {
  let [codeBrand, setCodeBrand] = useState("");
  let [nameBrand, setNameBrand] = useState("");
  let [idSelected, setIdSelected] = useState(id);
  let [errorCode, setErrorCode] = useState("");
  let [errorName, setErrorName] = useState("");

  useEffect(() => {
    if (id != null) {
      handelDetail();
    }
  }, [visible]);

  const handelDetail = () => {
    AdBrandAPI.handelDetail(id).then((res) => {
      console.log(res.data);
      setCodeBrand(res.data.code);
      setNameBrand(res.data.name);
      //   console.log(id);
    });
  };

  const handelUpdate = () => {
    let check = 0;
    if (codeBrand === "") {
      setErrorCode("* Vui lòng nhập mã hợp lệ");
      check++;
    } else {
      setErrorCode("");
    }
    if (nameBrand === "") {
      setErrorName("* Vui lòng nhập tên hợp lệ");
      check++;
    } else {
      setErrorName("");
    }
    if (check === 0) {
      let obj = {
        code: codeBrand,
        name: nameBrand,
      };
      AdBrandAPI.handelUpdate(id, obj).then((res) => {
        message.success("Thay đổi thành công!");
        onCancel();
        fetchAll();
      });
    }
  };

  return (
    <Modal
      title="Brand detail"
      open={visible}
      onCancel={onCancel}
      footer={null}
    >
      <div className="modal-detail">
        <hr></hr>
        <span>Mã loại: </span>
        <Input
          style={{ marginTop: "10px" }}
          value={codeBrand}
          onChange={(e) => setCodeBrand(e.target.value)}
        />
        <span style={{ color: "red" }}>{errorCode}</span>
        <br></br>
        <span>Tên loại: </span>
        <Input
          style={{ marginTop: "10px" }}
          value={nameBrand}
          onChange={(e) => setNameBrand(e.target.value)}
        />
        <span style={{ color: "red" }}>{errorName}</span>
        <Button
          type="primary"
          style={{
            background: "rgb(255, 215, 0)",
            marginTop: "10px",
            marginLeft: "270px",
            width: "200px",
            borderColor: "rgb(255, 215, 0)",
          }}
          onClick={() => handelUpdate(id)}
        >
          Sửa
        </Button>
      </div>
    </Modal>
  );
};
export default ModalDetail;
