package kodlama.io.rentacar.api.controllers;

import kodlama.io.rentacar.business.abstracts.MaintenanceService;
import kodlama.io.rentacar.business.dto.requests.create.CreateMaintenanceRequest;
import kodlama.io.rentacar.business.dto.responses.create.CreateMaintenanceResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/maintenances")
public class MaintenanceController {
    private final MaintenanceService service;

    @PostMapping
    public CreateMaintenanceResponse add(@RequestBody CreateMaintenanceRequest request){
        return service.add(request);
    }
}
