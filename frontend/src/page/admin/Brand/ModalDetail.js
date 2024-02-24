import { useEffect, useState } from "react";
import { AdBrandAPI } from "../../../api/admin/AdBrandApi";
import { Input, Modal } from "antd";

const ModalDetail = ({ visible, onCancel, id }) => {
  let [codeCategory, setCodeCategory] = useState("");
  let [nameCategory, setNameCategory] = useState("");

  useEffect(() => {
    if (id != null) {
      handelDetail();
    }
  }, [visible]);

  const handelDetail = () => {
    AdBrandAPI.handelDetail(id).then((res) => {
      console.log(res.data);
      setCodeCategory(res.data.code);
      setNameCategory(res.data.name);
      //   console.log(id);
    });
  };
  return (
    <Modal
      title="Category detail"
      open={visible}
      onCancel={onCancel}
      footer={null}
    >
      <div className="modal-detail">
        <hr></hr>
        <span>Mã loại: </span>
        <Input
          style={{ marginTop: "10px" }}
          value={codeCategory}
          readOnly={true}
          onChange={(e) => setCodeCategory(e.target.value)}
        />
        <span>Tên loại: </span>
        <Input
          style={{ marginTop: "10px" }}
          value={nameCategory}
          readOnly={true}
          onChange={(e) => setNameCategory(e.target.value)}
        />
      </div>
    </Modal>
  );
};
export default ModalDetail;
