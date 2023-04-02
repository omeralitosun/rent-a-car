package kodlama.io.rentacar.business.dto.requests.create;

import kodlama.io.rentacar.entities.Car;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateMaintenanceRequest {
    private LocalDate date;
    private int carId;
}

