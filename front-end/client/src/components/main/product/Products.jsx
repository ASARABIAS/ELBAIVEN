import { useEffect, useState } from 'react';
import { get } from '../../../service/methodApi';
import CardArticule from '../../CardArticule';
import { cartQuantityYisSaleBox } from '../../../service/tools';

const Products = ({ addCart, cart }) => {
    const [answer, setAnswer] = useState({});

    useEffect(() => {
        get('products')
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
        </>

    );
}

export default Products;
