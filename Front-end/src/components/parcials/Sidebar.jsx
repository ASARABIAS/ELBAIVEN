import Offcanvas from 'react-bootstrap/Offcanvas';
import ListGroup from 'react-bootstrap/ListGroup';
import { Link } from 'react-router-dom';

const Sidebar = (props) => {
    return (
        <Offcanvas {...props}>
            <Offcanvas.Header closeButton>
                <Offcanvas.Title><Link to={'/'} onClick={props.onHide}>EL BAIVEN</Link></Offcanvas.Title>
            </Offcanvas.Header>
            <Offcanvas.Body>
                <ListGroup variant="flush">
                    <ListGroup.Item><i class="fa-solid fa-wine-bottle me-3"></i>Cerveza
                        <ListGroup variant="flush">
                            <ListGroup.Item>Costeña</ListGroup.Item>
                            <ListGroup.Item>Dapibus ac facilisis in</ListGroup.Item>
                            <ListGroup.Item>Morbi leo risus</ListGroup.Item>
                            <ListGroup.Item>Porta ac consectetur ac</ListGroup.Item>
                        </ListGroup>
                    </ListGroup.Item>
                    <ListGroup.Item>Dapibus ac facilisis in</ListGroup.Item>
                    <ListGroup.Item>Morbi leo risus</ListGroup.Item>
                    <ListGroup.Item>Porta ac consectetur ac</ListGroup.Item>
                </ListGroup>
            </Offcanvas.Body>
        </Offcanvas>
    );
}

export default Sidebar;
