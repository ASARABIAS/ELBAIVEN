package co.com.elbaiven.sale.model;

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
@Table("sales")
public class SaleModel {
    @Id
    @Column("id")
    private Long id;
    @Column("iduser")
    private Long idUser;
    @Column("date")
    private Date date;
    @Column("total")
    private Float total;
}
