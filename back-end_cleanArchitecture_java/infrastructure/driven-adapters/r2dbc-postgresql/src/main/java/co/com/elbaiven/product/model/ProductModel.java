package co.com.elbaiven.product.model;

import co.com.elbaiven.model.type.Type;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("products")
public class ProductModel {
    @Id
    @Column("id")
    private Long id;
    @Column("idtype")
    private int idType;
    @Column("name")
    private String name;
    @Column("quantity")
    private Long quantity; // x unit
    @Column("description")
    private String description;
    @Column("price")
    private Float price;
    @Column("discount")
    private Double discount;
    @Column("image")
    private String image;
}
