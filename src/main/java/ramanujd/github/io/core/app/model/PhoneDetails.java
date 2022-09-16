package ramanujd.github.io.core.app.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "phone_details")
public class PhoneDetails {

    @Id
    @GeneratedValue
    private Long id;
    private String sid;
    private String name;
    private String brand;
    private short year;
    private String model;
}
