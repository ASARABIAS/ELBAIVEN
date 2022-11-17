package co.com.elbaiven.model.sale;
import co.com.elbaiven.model.user.User;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder(toBuilder = true)
public class Sale {
    private Long id;
    private User user;
    private Date date;
    private Double total;
}
