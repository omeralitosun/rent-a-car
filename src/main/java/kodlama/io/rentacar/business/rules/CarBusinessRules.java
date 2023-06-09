package kodlama.io.rentacar.business.rules;

import kodlama.io.rentacar.common.constants.Messages;
import kodlama.io.rentacar.core.exceptions.BusinessException;
import kodlama.io.rentacar.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarBusinessRules {

    private final CarRepository repository;

    public void checkIfCarExistsById(int id){
        if(!repository.existsById(id)) throw new BusinessException(Messages.Car.NotExists);
    }

    public void checkIfCarExistsByPlate(String plate){
        if(repository.existsByPlateIgnoreCase(plate)) throw new BusinessException(Messages.Car.PlateExists);
    }
}
