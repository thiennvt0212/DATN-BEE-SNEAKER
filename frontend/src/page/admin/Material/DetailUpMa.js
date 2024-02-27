import * as React from 'react';
import {
    faArrowUp,
    faCalendarDay,
    faEye,
    faFilter,
    faPen,
    faPlusMinus,
    faTrashCan,
} from "@fortawesome/free-solid-svg-icons"; import TextField from '@mui/material/TextField';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogContentText from '@mui/material/DialogContentText';
import DialogTitle from '@mui/material/DialogTitle';
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { Button, Input, Radio, Space, Table, message } from "antd";
import { useEffect, useState, useRef } from "react";


export function FormDuDialog({ data, onSubmit }) {
    const [open, setOpen] = React.useState(false);
    const codeInput = useRef();
    const nameInput = useRef();
    const [codeState, setCodeInput] = useState(null);
    const [nameState, setNameInput] = useState(null);



    const handleClickOpen = () => {
        setOpen(true);
        setCodeInput(data.code);
        codeInput.current = codeState;
        setNameInput(data.name);
        nameInput.current = nameState;
    };

    const handleClose = () => {
        setOpen(false);
    };

    const submitClick = () => {
        const code = codeState;
        const name = nameState;
        onSubmit(data.id, code, name);
        handleClose();
    }

    return (
        <React.Fragment>
            <FontAwesomeIcon
                icon={faEye}
                onClick={handleClickOpen}
                style={{ marginRight: 15, fontSize: "20px" }}
            ></FontAwesomeIcon>
            <Dialog
                open={open}
                onClose={handleClose}
                PaperProps={{
                    component: 'form',

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
                        value={codeState}
                        onChange={(event) => setCodeInput(event.target.value)}
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
                        value={nameState}
                        onChange={(event) => setNameInput(event.target.value)}
                        fullWidth
                        variant="standard"
                    />
                </DialogContent>
                <DialogActions>
                    <Button onClick={handleClose}>Cancel</Button>
                    <Button type="submit" onClick={submitClick}>Update</Button>
                </DialogActions>
            </Dialog>
        </React.Fragment>
    );
}