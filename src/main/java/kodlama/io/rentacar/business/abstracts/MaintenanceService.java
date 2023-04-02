package kodlama.io.rentacar.business.abstracts;

import kodlama.io.rentacar.business.dto.requests.create.CreateMaintenanceRequest;
import kodlama.io.rentacar.business.dto.responses.create.CreateMaintenanceResponse;

public interface MaintenanceService {
    CreateMaintenanceResponse add(CreateMaintenanceRequest request);
}
