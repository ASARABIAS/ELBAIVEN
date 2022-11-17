package co.com.elbaiven.model.person;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Person {
    private Long id;
    private Long identification;
    private String name;
    private String address;
    private String geolocation;
    private Long phone;
}
