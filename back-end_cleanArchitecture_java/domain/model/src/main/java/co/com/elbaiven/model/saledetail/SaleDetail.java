package co.com.elbaiven.model.saledetail;
import co.com.elbaiven.model.product.Product;
import co.com.elbaiven.model.sale.Sale;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class SaleDetail {
    private Long id;
    private Sale sale;
    private Product product;
    private Long quantity;
}
