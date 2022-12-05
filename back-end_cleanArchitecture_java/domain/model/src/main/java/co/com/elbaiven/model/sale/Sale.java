package co.com.elbaiven.model.sale;
import co.com.elbaiven.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sale {
    private Long id;
    private Long idUser;
    private LocalDateTime date;
    private Float total;
}
