package kodlama.io.rentacar.business.dto.responses.update;

import kodlama.io.rentacar.entities.enums.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCarResponse {
    private int id;
    private int modelYear;
    private String plate;
    private State state; // 1 - Available, 2 - Rented, 3 - Maintance
    private double dailyPrice;
    private int modelId;
}
