import * as React from 'react';
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogTitle from '@mui/material/DialogTitle';
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faPlusMinus } from "@fortawesome/free-solid-svg-icons";
import { Input, Table, message } from "antd";


export function FormDialog({onSubmit}) {
    const [open, setOpen] = React.useState(false);

    const handleClickOpen = () => {
        setOpen(true);
    };

    const handleClose = () => {
        setOpen(false);
    };

    return (
        <React.Fragment>
           
 <div style={{ marginTop: 30 }}>
          <Input className="input-search"
            style={{
              width: "350px",
              height: "35px",
              right: 330,
              marginRight: "20px",
            }}
            placeholder="Nhập tên sản phẩm cần tìm..."
            // value={findBrand}
            // onChange={(e) => setFindBrand(e.target.value)}
          />
        

          <Button style={{ left: 300 }} onClick={handleClickOpen}>
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

            <Dialog
                open={open}
                onClose={handleClose}
                PaperProps={{
                    component: 'form',
                    onSubmit: (event) => {
                        event.preventDefault();
                        const formData = new FormData(event.currentTarget);
                        const formJson = Object.fromEntries((formData).entries());
                        const code = formJson.code;
                        const name = formJson.name;
                        onSubmit(code, name);
                        handleClose();
                    },
                }}
            >
                <DialogTitle>Mời Nhập</DialogTitle>
                <DialogContent>
                
                    <TextField
                        autoFocus
                        required
                        margin="dense"
                        id="code"
                        name="code"
                        label="Code"
                        fullWidth
                        variant="standard"
                    />
                    <TextField
                        autoFocus
                        required
                        margin="dense"
                        id="name"
                        name="name"
                        label="Name"
                        fullWidth
                        variant="standard"
                    />
                </DialogContent>
                <DialogActions>
                    <Button onClick={handleClose}>Cancel</Button>
                    <Button type="submit">Add</Button>
                </DialogActions>
            </Dialog>
        </React.Fragment>
    );
}