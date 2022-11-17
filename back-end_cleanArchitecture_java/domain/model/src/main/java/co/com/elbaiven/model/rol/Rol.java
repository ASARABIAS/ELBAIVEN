package co.com.elbaiven.model.rol;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Rol {
    private int id;
    private String name;
}
