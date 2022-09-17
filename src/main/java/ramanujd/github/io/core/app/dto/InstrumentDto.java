package ramanujd.github.io.core.app.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class InstrumentDto {
    private Long id;
    private String name;
    private String assetClass;
    private String type;
    private String currencyCode;
    private BigDecimal price;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
}
