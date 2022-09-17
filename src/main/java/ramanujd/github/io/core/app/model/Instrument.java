package ramanujd.github.io.core.app.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@Entity
@Table(name = "instrument")
public class Instrument {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String assetClass;
    private String type;
    private String currencyCode;
    private BigDecimal price;
    private LocalDate date;
}
