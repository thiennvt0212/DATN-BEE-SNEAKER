// import React, { useState } from 'react';

// const AddColor = ({ onSubmit }) => {
   
//   const [stt, setStt] = useState('');
//   const [ma, setMa] = useState('');
//   const [ten, setTen] = useState('');

//   const handleSttChange = (e) => {
//     setStt(e.target.value);
//   };

//   const handleMaChange = (e) => {
//     setMa(e.target.value);
//   };

//   const handleTenChange = (e) => {
//     setTen(e.target.value);
//   };

//   const handleSubmit = (e) => {
//     e.preventDefault();

//     // Kiểm tra và xử lý dữ liệu nếu cần
//     if (!stt || !ma || !ten) {
//       alert('Vui lòng nhập đầy đủ thông tin');
//       return;
//     }

//     // Gọi hàm onSubmit để chuyển dữ liệu lên component cha
//     onSubmit({ stt, ma, ten });

//     // Reset giá trị sau khi submit
//     setStt('');
//     setMa('');
//     setTen('');
//   };

//   return (
//     <form onSubmit={handleSubmit}>
//       <div>
//         <label>STT:</label>
//         <input type="text" value={stt} onChange={handleSttChange} />
//       </div>
//       <div>
//         <label>Mã:</label>
//         <input type="text" value={ma} onChange={handleMaChange} />
//       </div>
//       <div>
//         <label>Tên:</label>
//         <input type="text" value={ten} onChange={handleTenChange} />
//       </div>
//       <button type="submit">Thêm</button>
//     </form>
//   );
// };

// export default AddColor ;
