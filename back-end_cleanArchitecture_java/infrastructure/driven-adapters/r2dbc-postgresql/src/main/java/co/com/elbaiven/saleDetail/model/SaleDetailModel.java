package co.com.elbaiven.saleDetail.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("saledetails")
public class SaleDetailModel {
    @Id
    @Column("id")
    private Long id;
    @Column("idsale")
    private Long idSale;
    @Column("idproduct")
    private Long idProduct;
    @Column("quantity")
    private Long quantity;
    @Column("subtotal")
    private Float subtotal;
}
