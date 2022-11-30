package co.com.elbaiven.model.person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private Long id;
    private Long identification;
    private String name;
    private String address;
    private String geolocation;
    private Long phone;
}
