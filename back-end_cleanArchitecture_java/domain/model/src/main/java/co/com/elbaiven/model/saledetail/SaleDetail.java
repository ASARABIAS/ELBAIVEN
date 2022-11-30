package co.com.elbaiven.model.saledetail;
import co.com.elbaiven.model.product.Product;
import co.com.elbaiven.model.sale.Sale;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleDetail {
    private Long id;
    private Long idSale;
    private Long idProduct;
    private Long quantity;
    private Float subtotal;
}
