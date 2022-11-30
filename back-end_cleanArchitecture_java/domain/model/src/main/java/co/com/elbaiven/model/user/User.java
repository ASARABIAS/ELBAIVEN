package co.com.elbaiven.model.user;
import co.com.elbaiven.model.person.Person;
import co.com.elbaiven.model.rol.Rol;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private Long idPerson;
    private String email;
    private String password;
    private int idRol;
}
