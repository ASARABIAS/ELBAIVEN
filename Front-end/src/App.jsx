import { Routes, Route } from 'react-router-dom';
import InfModal from './components/parcials/InfModal';
import Products from './components/main/product/Products';
import TopBar from './components/parcials/TopBar';
import Sidebar from './components/parcials/Sidebar';
import Index from './components/main/Index';
import Footer from './components/parcials/Footer';
import { useState } from 'react';
import ShoppingCart from './components/parcials/ShoppingCart';
import DetailProduct from './components/main/product/DetailProduct';
import Payment from './components/main/payment/Payment';
import MapDelivery from './components/main/payment/MapDelivery';


function App() {

  /*
  const [show, setShow] = useState(false);

  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);
*/


  const [cart, setCart] = useState([]);
  const [quantity, setQuantity] = useState(0);
  const [showShoppingCart, setShowShoppingCart] = useState(false);

  const addCart = (product) => {
    let auxCart;
    const exitsProductCart = cart.find(item => item.id === product.id);
    if (exitsProductCart) {
      cart[cart.indexOf(exitsProductCart)] = product;
      auxCart = cart;
    } else {
      auxCart = [...cart, product];
    }
    setCart(auxCart);
    auxQuantity(auxCart);
  }

  const auxQuantity = (array) => {
    let count = 0;
    array.forEach(item => {
      count += Number(item.quantity);
    });
    setQuantity(count);
  }

  const deleteCart = (productId) => {
    const auxCart = cart.filter(item => item.id != productId);
    setCart(auxCart);
    auxQuantity(auxCart);
    if (auxCart.length === 0) handleCloseShoppingCart();
  }

  const handleCloseShoppingCart = () => setShowShoppingCart(false);
  const handleShowShoppingCart = () => setShowShoppingCart(true);

  return (
    <>
      <InfModal />
      {/* <TopBar
        handleShow={handleShow}
      />

      <Sidebar
        show={show} 
        onHide={handleClose}
      />*/
      }

      <TopBar
        quantity={quantity}
        handleShowShoppingCart={handleShowShoppingCart}
        cart={cart}
      />

      <ShoppingCart
        show={showShoppingCart}
        onHide={handleCloseShoppingCart}
        cart={cart}
        deleteCart={deleteCart}
      />

      <Routes>

        <Route exact path="/"
          element={
            <Index
              addCart={addCart}
              cart={cart}
            />
          }
        />
        <Route path="/products"
          element={
            <Products
              addCart={addCart}
              cart={cart}
            />
          }
        />
        <Route path='/products/:id'
          element={
            <DetailProduct
              addCart={addCart}
              cart={cart}
            />
          }
        />
        <Route path='/payment'
          element={
            <Payment
              cart={cart}
            />
          }
        />
        <Route path='/prueba'
          element={
            <MapDelivery
              cart={cart}
            />
          }
        />


      </Routes>


    </>
  );
}

export default App;
