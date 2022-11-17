package co.com.elbaiven.model.type;
import co.com.elbaiven.model.category.Category;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Type {
    private int id;
    private Category category;
    private String name;
    private String image;
}
