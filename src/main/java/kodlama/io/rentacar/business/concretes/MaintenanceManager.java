package kodlama.io.rentacar.business.concretes;

import kodlama.io.rentacar.business.abstracts.CarService;
import kodlama.io.rentacar.business.abstracts.MaintenanceService;
import kodlama.io.rentacar.business.dto.requests.create.CreateMaintenanceRequest;
import kodlama.io.rentacar.business.dto.requests.update.UpdateCarRequest;
import kodlama.io.rentacar.business.dto.responses.create.CreateMaintenanceResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetCarResponse;
import kodlama.io.rentacar.entities.Car;
import kodlama.io.rentacar.entities.Maintenance;
import kodlama.io.rentacar.repository.MaintenanceRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MaintenanceManager implements MaintenanceService {
    private final MaintenanceRepository repository;
    private final CarService carService;
    private final ModelMapper mapper;
    @Override
    public CreateMaintenanceResponse add(CreateMaintenanceRequest request) {
        GetCarResponse car = carService.getById(request.getCarId());
        checkIfCarStatuAvailable(car);
        car.setState(3);
        carService.update(car.getId(),mapper.map(car, UpdateCarRequest.class));

        Maintenance maintenance = mapper.map(request,Maintenance.class);
        maintenance.setId(0);
        maintenance.setCar(mapper.map(car, Car.class));
        repository.save(maintenance);
        CreateMaintenanceResponse response = mapper.map(maintenance, CreateMaintenanceResponse.class);

        return response;
    }

    // Business rules

    void checkIfCarStatuAvailable(GetCarResponse car){
        if(car.getState()!=1) throw new RuntimeException("Araç bakıma gönderilemez");
    }
}
