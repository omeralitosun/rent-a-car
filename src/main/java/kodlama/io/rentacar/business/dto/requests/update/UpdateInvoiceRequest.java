package kodlama.io.rentacar.business.dto.requests.update;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateInvoiceRequest {

    @NotBlank
    private String cardHolder;
    @NotBlank
    private String modelName;
    @NotBlank
    private String brandName;
    @NotNull
    private int modelYear;
    @NotNull
    private double dailyPrice;
    @NotNull
    private double totalPrice;
    @NotNull
    private int rentedForDays;
    private LocalDateTime rentedAt;
}
