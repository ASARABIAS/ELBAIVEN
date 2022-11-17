package co.com.elbaiven.model.category;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Category {
    private int id;
    private String name;
    private String image;
}
