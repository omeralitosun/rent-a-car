package kodlama.io.rentacar.business.dto.requests.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCarRequest {
    private int modelYear;
    private String plate;
    private int state; // 1 - Available, 2 - Rented, 3 - Maintance
    private double dailyPrice;
    private int modelId;
}

