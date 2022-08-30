import { useState } from 'react';
import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';

const InfModal = () => {
    const [show, setShow] = useState(true);

    const handleClose = () => setShow(false);

    return (
        <Modal
            size="lg"
            aria-labelledby="contained-modal-title-vcenter"
            centered
            show={show}
            onHide={handleClose}
        >
            <Modal.Header closeButton>
                <Modal.Title id="contained-modal-title-vcenter">
                    EL BAIVEN
                </Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <p>
                    Hola mi amig@, aqui puedes encontrar todo lo que el EL BAIVEN tiene para ti.
                    <br />
                    <br />
                    <small>💥 para que tengas mejor experiencia, te recomiendo utilizar tu telefono inteligente 😎</small>
                </p>
                <small style={{fontSize:'11px'}}>Prometemos que es bastante interesante y a buen precio 😅</small>
            </Modal.Body>
            <Modal.Footer>
                <Button onClick={handleClose}>Ok</Button>
            </Modal.Footer>
        </Modal>
    );
}

export default InfModal;
