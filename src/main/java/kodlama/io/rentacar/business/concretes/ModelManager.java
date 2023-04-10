package kodlama.io.rentacar.business.concretes;

import kodlama.io.rentacar.business.abstracts.ModelService;
import kodlama.io.rentacar.business.dto.requests.create.CreateModelRequest;
import kodlama.io.rentacar.business.dto.requests.update.UpdateModelRequest;
import kodlama.io.rentacar.business.dto.responses.create.CreateModelResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetAllModelResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetModelResponse;
import kodlama.io.rentacar.business.dto.responses.update.UpdateModelResponse;
import kodlama.io.rentacar.entities.Model;
import kodlama.io.rentacar.repository.ModelRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private final ModelRepository repository;
    private final ModelMapper mapper;

    @Override
    public CreateModelResponse add(CreateModelRequest request) {
        checkIfModelExistsByName(request.getName());
        Model model = mapper.map(request, Model.class);
        model.setId(0);
        repository.save(model);
        CreateModelResponse response = mapper.map(model,CreateModelResponse.class);

        return response;
    }

    @Override
    public UpdateModelResponse update(int id, UpdateModelRequest request) {
        checkIfModelExistsById(id);

        Model model = mapper.map(request, Model.class);
        model.setId(id);
        repository.save(model);
        UpdateModelResponse response = mapper.map(model,UpdateModelResponse.class);

        return response;
    }

    @Override
    public void delete(int id) {
        checkIfModelExistsById(id);
        repository.deleteById(id);
    }

    @Override
    public GetModelResponse getById(int id) {
        checkIfModelExistsById(id);

        Model model = repository.findById(id).orElseThrow();
        GetModelResponse response = mapper.map(model,GetModelResponse.class);
        return response;
    }

    @Override
    public List<GetAllModelResponse> getAll() {
        List<Model> models = repository.findAll();
        List<GetAllModelResponse> response = models
                .stream()
                .map(model -> mapper.map(model,GetAllModelResponse.class))
                .toList();

        return response;
    }

    // Business rules

    private void checkIfModelExistsById(int id){
        if (!repository.existsById(id)) throw new RuntimeException("Böyle bir model mevcut değil");
    }

    private void checkIfModelExistsByName(String name){
        if (repository.existsByNameIgnoreCase(name)) throw new RuntimeException("Böyle bir isimde model mevcut");
    }
}
