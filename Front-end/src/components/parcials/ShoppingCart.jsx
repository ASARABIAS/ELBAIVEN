import Offcanvas from 'react-bootstrap/Offcanvas';
import ListGroup from 'react-bootstrap/ListGroup';
import Button from 'react-bootstrap/Button';
import { useState, useEffect } from 'react';
import { Link, useNavigate } from 'react-router-dom';

const ShoppingCart = ({ show, onHide, cart, deleteCart }) => {
    const [total, setTotal] = useState(0);
    const navegate = useNavigate();

    useEffect(() => {
        let sum = 0;
        cart.forEach(item => {
            sum += item.price;
        });
        setTotal(sum);
    }, [cart]);


    return (
        <>
            <Offcanvas show={show} onHide={onHide} placement='end' >
                <Offcanvas.Header closeButton>
                    <Offcanvas.Title>Carrito</Offcanvas.Title>
                </Offcanvas.Header>
                <Offcanvas.Body>
                    <ListGroup as="ol" numbered className='my-1'>
                        {cart.map((item, i) => {
                            return (
                                <ListGroup.Item as="li" className="d-flex justify-content-between align-items-start position-relative my-2 border-0 bg-light" key={i}>
                                    <div className="position-absolute top-0 start-100 translate-middle rounded-circle p-1 bg-body text-danger"><i className="fa-solid fa-trash-can" onClick={() => deleteCart(item.id)}></i></div>
                                    <div className="ms-2 me-auto">

                                        <div className="fw-bold">
                                            <Link to={`/products/${item.id}`} onClick={onHide}>
                                                {item.name}
                                            </Link>
                                            <small className='text-success'> $ {(item.price * item.quantity).toLocaleString('de-DE')}</small>
                                        </div>

                                        <div className='p-0 mx-1'>
                                            <small>{`${item.quantity}x $${(item.price).toLocaleString('de-DE')}`}</small>
                                        </div>
                                        <small className='mx-2'>paquete de {item.isSaleSixpack === 1 && !item.isSaleBox ? '6' : item.isSaleSixpack === 1 && item.isSaleBox ? '24' : '30'} unidades.</small>
                                    </div>
                                    <div className=" align-self-center d-flex align-items-center">
                                        <small className='mx-1 text-warning text-center fs-3'>{item.quantity}</small>
                                    </div>

                                </ListGroup.Item>
                            );
                        })}
                    </ListGroup>
                    <div className='text-end my-4'>
                        <strong>Total: <p className='text-info d-inline'>${total.toLocaleString('de-DE')}</p></strong>
                    </div>
                    <div className='text-center my-4'>
                        <Button variant="primary" onClick={()=>{onHide();navegate('/payment')}}>
                            Comprar
                        </Button>
                    </div>
                </Offcanvas.Body>
            </Offcanvas>
        </>
    );
}

export default ShoppingCart;
