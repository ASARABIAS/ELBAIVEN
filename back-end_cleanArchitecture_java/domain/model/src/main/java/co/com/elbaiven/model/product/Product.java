package co.com.elbaiven.model.product;
import co.com.elbaiven.model.type.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Long id;
    private int idType;
    private String name;
    private Long quantity; // x unit
    private String description;
    private Float price;
    private Double discount;
    private String image;
}
