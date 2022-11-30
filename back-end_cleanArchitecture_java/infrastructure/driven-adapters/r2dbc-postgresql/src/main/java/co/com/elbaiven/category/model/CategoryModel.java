package co.com.elbaiven.category.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("categories")
public class CategoryModel {
    @Id
    @Column("id")
    private int id;
    @Column("name")
    private String name;
    @Column("image")
    private String image;
}
