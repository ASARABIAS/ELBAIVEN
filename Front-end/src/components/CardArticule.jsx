import Card from 'react-bootstrap/Card';
import Form from 'react-bootstrap/Form';
import FloatingLabel from 'react-bootstrap/FloatingLabel';
import Button from 'react-bootstrap/Button';
import { useState} from 'react';
import { Link } from 'react-router-dom';

const CardArticule = (props) => {
    const [disabled, setDisabled] = useState(true);
    const [formCheck, setFormCheck] = useState(false);
    const [price, setPrice] = useState(props.price);
    const [data, setData] = useState({ isSaleBox: props.cartQuantityYisSaleBox ? props.cartQuantityYisSaleBox.isSaleBox : false, quantity: props.cartQuantityYisSaleBox ? props.cartQuantityYisSaleBox.quantity : '0' });

    const handleChange = (event) => {
        const { name, value } = event.target;
        if (data.quantity != 0 || name === 'quantity') setDisabled(false);
        if (name === 'isSaleBox') {
            !data.isSaleBox ? setPrice(props.price * 4) : setPrice(props.price);
            setData({ ...data, isSaleBox: !data.isSaleBox });
        } else {
            setData({ ...data, [name]: value });
        }
    }

    const onSubmitForm = (event) => event.preventDefault();

    const enableFormCheck = () => {
        setFormCheck(!formCheck);
    }

    const onClickAddCart = () => {
        setDisabled(true);
        props.addCart({ id: props.id, name: props.name, price, quantity: data.quantity, isSaleBox: data.isSaleBox, isSaleSixpack: props.isSaleSixpack });
    }

    return (
        <Card style={{ width: '18rem' }} className='m-3' >
            <Card.Img variant="top" src={`${props.urlStaticImages}/${props.image}`} style={{ width: '100px' }} className='m-auto' />
            <Card.Body>
                <Card.Title>
                    <Link to={`/products/${props.id}`}>
                        <strong>
                            {props.name}
                        </strong>
                    </Link>
                </Card.Title>
                <Card.Title>
                    {`$ ${price.toLocaleString('de-DE')}`}
                </Card.Title>
                <Card.Text>
                    {props.description}
                </Card.Text>
                <Form onSubmit={onSubmitForm}>
                    <FloatingLabel onFocus={enableFormCheck} controlId="floatingInput" label="Cantidad">
                        <Form.Control
                            onChange={handleChange}
                            value={data.quantity}
                            type="number"
                            min="0"
                            name="quantity"
                            placeholder="Cantidad"
                            className="form-control-lg border-0"
                        />

                    </FloatingLabel>
                    <p className="mx-3" style={{ fontSize: '10px' }}>
                        paquete de {props.isSaleSixpack === 1 && !data.isSaleBox ? '6' : props.isSaleSixpack === 1 && data.isSaleBox ? '24' : '30'} unidades.
                    </p>
                    {props.isSaleSixpack === 1 && formCheck || props.isSaleSixpack === 1 && data.isSaleBox ?
                        <>
                            <Form.Check
                                onChange={handleChange}
                                type="switch"
                                name="isSaleBox"
                                id="custom-switch"
                                label="x Caja"
                                className='mx-3'
                                checked={data.isSaleBox}
                            />
                            <p className="mx-3" style={{ fontSize: '10px' }}>
                                Una Caja es 4 Sixpack.
                            </p>
                        </>
                        :
                        ''
                    }
                </Form>
                <div className='text-center my-4'>
                    <Button variant="primary" disabled={disabled} onClick={onClickAddCart}>
                        Agregar al Carrito
                    </Button>
                </div>
            </Card.Body>
        </Card>
    );
}

export default CardArticule;
