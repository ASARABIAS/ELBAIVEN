package co.com.elbaiven.model.product;
import co.com.elbaiven.model.type.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
public class Product {
    private Long id;
    private Type type;
    private String name;
    private Long quantity; // x unit
    private String description;
    private Double price;
    private Double discount;
    private String image;
}
