import React, { useState, useRef } from 'react';
import { Link } from 'react-router-dom';
import { Navbar, Container, Nav, Badge } from 'react-bootstrap';
import icon from '../../assets/images/logo-300px.png';
import Overlay from 'react-bootstrap/Overlay';
import Tooltip from 'react-bootstrap/Tooltip';

const TopBar = ({ handleShow, quantity, handleShowShoppingCart, cart }) => {
    const [show, setShow] = useState(false);
    const target = useRef(null);

    const showShoppingCart = () => {
        cart.length > 0 ? handleShowShoppingCart() : setShow(!show);
    }

    return (
        <Navbar bg="dark" variant="dark" sticky="top">
            <Container>
                <Navbar.Brand onClick={handleShow}>
                    <Link to={'/'} className='text-white'>
                        <img
                            alt=""
                            src={icon}
                            width="30"
                            height="30"
                            className="d-inline-block align-top"
                        />{' '}
                        EL BAIVEN
                    </Link>
                </Navbar.Brand>
                <Navbar.Brand>
                    <Nav className="justify-content-end">
                        <Nav.Item>
                            <Nav.Link ref={target} onClick={showShoppingCart} onBlur={() => cart.length === 0 ? setShow(!show) : ''} className='text-white d-flex align-items-start'>
                                <i className="fa-solid fa-cart-shopping my-1"></i>
                                <small style={{ fontSize: '12px', width: '13px', height: '14px' }} className='mx-1 text-danger text-center'>{quantity}</small>
                            </Nav.Link>
                            <Overlay target={target.current} show={show} placement="left">
                                {(props) => (
                                    <Tooltip id="overlay-example" {...props}>
                                        No hay productos
                                    </Tooltip>
                                )}
                            </Overlay>
                        </Nav.Item>
                    </Nav>
                </Navbar.Brand>
            </Container>
        </Navbar>
    );
}

export default TopBar;
