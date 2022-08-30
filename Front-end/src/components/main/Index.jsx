import { useEffect, useState } from 'react';
import { get } from '../../service/methodApi';
import CardArticule from '../CardArticule';
import Button from 'react-bootstrap/Button';
import { Link } from 'react-router-dom';
import { cartQuantityYisSaleBox, deleteCartByProducId } from '../../service/tools';

const Index = ({ addCart, cart }) => {
    const [answer, setAnswer] = useState({});

    useEffect(() => {
        get('')
            .then(response => {
                setAnswer(response.answer);
            })
    }, []);

    return (
        <>
            <div className='card-columns d-flex flex-wrap align-items-center justify-content-center m-3'>
                {answer?.data?.map((item, i) => {
                    return (
                        <CardArticule
                            {...item}
                            cartQuantityYisSaleBox={cartQuantityYisSaleBox(cart, item.id)}
                            addCart={addCart}
                            urlStaticImages={answer.urlStaticImages}
                            key={i}
                        />
                    );
                })}
            </div>
            <div className='text-center'>
                <Link to='/products'>
                    <Button variant="primary">
                        Mas productos
                    </Button>
                </Link>
            </div>
        </>

    );
}

export default Index;
