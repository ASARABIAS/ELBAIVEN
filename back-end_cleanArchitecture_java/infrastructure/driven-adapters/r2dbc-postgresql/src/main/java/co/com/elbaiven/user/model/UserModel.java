package co.com.elbaiven.user.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("users")
public class UserModel {
    @Id
    @Column("id")
    private Long id;
    @Column("idperson")
    private Long idPerson;
    @Column("email")
    private String email;
    @Column("password")
    private String password;
    @Column("idrol")
    private int idRol;
}
