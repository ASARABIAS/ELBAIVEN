package co.com.elbaiven.rol.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("roles")
public class RolModel {
    @Id
    @Column("id")
    private int id;
    @Column("name")
    private String name;
}
