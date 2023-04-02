package kodlama.io.rentacar.business.abstracts;

import kodlama.io.rentacar.business.dto.requests.create.CreateBrandRequest;
import kodlama.io.rentacar.business.dto.requests.update.UpdateBrandRequest;
import kodlama.io.rentacar.business.dto.responses.create.CreateBrandResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetAllBrandResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetBrandResponse;
import kodlama.io.rentacar.business.dto.responses.update.UpdateBrandResponse;
import kodlama.io.rentacar.entities.Brand;

import java.util.List;

public interface BrandService {
    List<GetAllBrandResponse> getAll();
    GetBrandResponse getById(int id);
    CreateBrandResponse add(CreateBrandRequest request);
    UpdateBrandResponse update(int id, UpdateBrandRequest request);
    void delete(int id);
}
