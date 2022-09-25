import Button from 'react-bootstrap/Button';
import FloatingLabel from 'react-bootstrap/FloatingLabel';
import Form from 'react-bootstrap/Form';
import Card from 'react-bootstrap/Card';
import Spinner from 'react-bootstrap/Spinner';
import { useState, useEffect } from 'react';
import { getApiOutside, post } from '../../../service/methodApi';
import { useNavigate } from 'react-router-dom';

const Payment = ({ cart }) => {
    const [homeDelivery, setHomeDelivery] = useState(false);
    const [data, setData] = useState({ name: '', phone: '', homeDelivery: '' });
    const [showMessage, setShowMessage] = useState(false);
    const [showHomeDelivery, setShowHomeDelivery] = useState('');
    const [answerServer, setAnswerServer] = useState({ state: -1, text: null }); //state -1 => not send;0 => send; 1 => response
    const navigate = useNavigate();

    useEffect(() => {

        if (cart.length === 0) {
            navigate('/');
        } else {
            const localUser = localStorage.getItem('localUser');
            if (localUser) {
                const aux = JSON.parse(localUser);
                setData(aux);
                setHomeDelivery(aux.homeDelivery.length > 0);
                if (aux.homeDelivery.length > 0) {
                    const coordinates = aux.homeDelivery.split(',');
                    addressApi(coordinates[0], coordinates[1]);
                }

            }
        }
    }, []);

    const addressApi = (lat, lon) => {
        getApiOutside(`https://nominatim.openstreetmap.org/reverse?lat=${lat}&lon=${lon}&format=geojson`)
            .then(response => {
                const address = response?.features[0]?.properties.address;
                //setShowHomeDelivery(`${address.display_name}`)
                setShowHomeDelivery(`${address.road ? address.road + ',' : ''} ${address.town ? address.town + ','  : ''} ${address.state ? address.state + ','  : ''} ${address.country ? address.country : ''} `);
            });
    }

    const handleChange = (event) => {
        const { name, value } = event.target;
        setShowMessage(false);
        setData({ ...data, [name]: value });
    };

    const validation = () => data.name.length > 0 && data.phone.length > 0 ? sendData() : setShowMessage(true);

    const sendData = () => {
        setAnswerServer({ ...answerServer, ['state']: 0 });
        localStorage.setItem("localUser", JSON.stringify(data));
        console.log(data);
        console.log('cart: ', cart);
        post('shopping/store', { ...data, ['detailShopping']: cart })
    };

    const geolocation = () => {
        function success(pos) {
            let crd = pos.coords;
            console.log(crd.latitude + ',' + crd.longitude);
            setData({ ...data, ['homeDelivery']: crd.latitude + ',' + crd.longitude });
            addressApi(crd.latitude, crd.longitude);
        };

        function error(err) {
            console.warn('ERROR(' + err.code + '): ' + err.message);
        };

        navigator.geolocation.getCurrentPosition(success, error);
    }

    return (
        <div className='card-columns d-flex flex-wrap align-items-center justify-content-center m-3'>
            <Card style={{ width: '20rem' }}>
                <Card.Body>
                    <Card.Text>
                        Necesitamos los siguientes datos para procesar su orden
                    </Card.Text>
                    <FloatingLabel controlId="floatingInput" label="Nombre" className="mb-3">
                        <Form.Control type="text" placeholder="Nombre" name='name' onChange={handleChange} value={data.name} />
                    </FloatingLabel>
                    <FloatingLabel controlId="floatingInput" label="Telefono" className="mb-3">
                        <Form.Control type="number" placeholder="phone" name='phone' onChange={handleChange} value={data.phone} />
                    </FloatingLabel>
                    <Form.Check
                        type="switch"
                        name="isSaleBox"
                        id="custom-switch"
                        label="Entrega a Domicilio"
                        onChange={() => { !homeDelivery ? geolocation() : setData({ ...data, ['homeDelivery']: '' }); setHomeDelivery(!homeDelivery); }}
                        checked={homeDelivery}
                    />
                    {showHomeDelivery.length > 0 && data.homeDelivery ?
                        <Card.Text>
                            <small>{showHomeDelivery}</small>
                        </Card.Text> :
                        ''}

                    {data.homeDelivery ?
                        <>
                            <div className='text-center mt-2'>
                                {showHomeDelivery.length === 0 ?
                                    <Spinner animation="border" variant="primary" />
                                    :
                                    ''}
                            </div>
                            <Card.Text>
                                <small>💥 Para continuar vamos a solicitarte tu ubicacion. Para la entrega a domicilio 😎</small>
                            </Card.Text>
                        </>
                        :
                        ''}

                    <div className='text-center mt-4'>
                        <Button variant="primary" onClick={validation} className="mb-3">
                            Continuar
                        </Button>
                        {showMessage ?
                            <Card.Text>
                                <small>Primero llena los campos 😎</small>
                            </Card.Text> :
                            ''}
                    </div>
                    <div className='text-center mt-2'>
                        {answerServer.state === 0 ?
                            <Spinner animation="border" variant="primary" />
                            :
                            ''}
                    </div>
                </Card.Body>
            </Card>
        </div>


    );
}

export default Payment;
