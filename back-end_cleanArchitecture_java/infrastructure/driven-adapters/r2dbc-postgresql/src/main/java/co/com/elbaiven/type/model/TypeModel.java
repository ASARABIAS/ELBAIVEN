package co.com.elbaiven.type.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("types")
public class TypeModel {
    @Id
    @Column("id")
    private int id;
    @Column("idcategory")
    private int idCategory;
    @Column("name")
    private String name;
    @Column("image")
    private String image;
}
