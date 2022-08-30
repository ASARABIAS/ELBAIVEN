import { useEffect, useState } from 'react';
import { get } from '../../../service/methodApi';
import CardArticule from '../../CardArticule';
import Button from 'react-bootstrap/Button';
import { Link, useParams } from 'react-router-dom';
import { cartQuantityYisSaleBox } from '../../../service/tools';

const DetailProduct = ({ addCart, cart }) => {
    const [answer, setAnswer] = useState({});
    const { id } = useParams();

    useEffect(() => {
        get('products/' + id)
            .then(response => {
                console.log(response);
                setAnswer(response.answer);
            })
    }, []);


    return (
        <>
            <div className='card-columns d-flex flex-wrap align-items-center justify-content-center m-3'>
                {answer.data != null ?
                    <CardArticule
                        {...answer.data}
                        cartQuantityYisSaleBox={cartQuantityYisSaleBox(cart, answer.data.id)}
                        addCart={addCart}
                        urlStaticImages={answer.urlStaticImages}
                    />
                    :
                    ''
                }
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

export default DetailProduct;
