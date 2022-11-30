package co.com.elbaiven.model.type;
import co.com.elbaiven.model.category.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Type {
    private int id;
    private int idcategory;
    private String name;
    private String image;
}
