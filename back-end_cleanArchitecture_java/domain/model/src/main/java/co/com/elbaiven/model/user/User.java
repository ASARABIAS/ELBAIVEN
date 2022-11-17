package co.com.elbaiven.model.user;
import co.com.elbaiven.model.person.Person;
import co.com.elbaiven.model.rol.Rol;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class User {
    private Long id;
    private Person person;
    private String email;
    private String password;
    private Rol rol;
}
