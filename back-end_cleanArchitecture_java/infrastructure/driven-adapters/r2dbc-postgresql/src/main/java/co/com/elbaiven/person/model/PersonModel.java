package co.com.elbaiven.person.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("people")
public class PersonModel {
    @Id
    @Column("id")
    private Long id;
    @Column("identification")
    private Long identification;
    @Column("name")
    private String name;
    @Column("address")
    private String address;
    @Column("geolocation")
    private String geolocation;
    @Column("phone")
    private Long phone;
}
