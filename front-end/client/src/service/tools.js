
/*know if it exists the product in the cart for assign the quantity and isSaleBox to the card*/
export const cartQuantityYisSaleBox = (cart, productId) => {
    let quantityYisSaleBox = {
        quantity: 0,
        isSaleBox: false
    };
    const elementCart = cart.find(element => element.id === productId);
    const productofCard = cart[cart.indexOf(elementCart)];
    if (elementCart) {
        quantityYisSaleBox.quantity = productofCard.quantity;
        quantityYisSaleBox.isSaleBox = productofCard.isSaleBox;
    }
    return quantityYisSaleBox;
}
