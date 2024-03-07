import { useEffect, useState } from "react";
import { AdBrandAPI } from "../../../api/admin/AdBrandApi";
import { Button, Input, Modal, message } from "antd";

const ModalAdd = ({visible, onCancel, fetchAll}) =>{
    let [codeBrand, setCodeBrand] = useState("");
  let [nameBrand, setNameBrand] = useState("");
  let [errorCode, setErrorCode] = useState("");
  let [errorName, setErrorName] = useState("");

  useEffect(() => {
    setCodeBrand("");
    setNameBrand("");
    setErrorCode("");
    setErrorName("");
  }, [visible]);

  const handelAdd = () => {
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
      AdBrandAPI.handelAdd(obj).then((res) => {
        message.success("Thêm mới thành công!");
        onCancel();
        fetchAll();
      });
    }
  };
    return (
<Modal
      title="Thêm thương hiệu"
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
        <span style={{ color: "red" }}>{errorCode}</span><br></br>
        <span>Tên loại: </span>
        <Input
          style={{ marginTop: "10px" }}
          value={nameBrand}
          onChange={(e) => setNameBrand(e.target.value)}
        />
        <span style={{ color: "red" }}>{errorName}</span>
        <Button
          style={{ marginTop: "10px", marginLeft: "270px", width: "200px" }}
          onClick={handelAdd}
          type="primary"
          htmlType="submit"
        >
          Add
        </Button>
      </div>
    </Modal>
    );
}
export default ModalAdd;