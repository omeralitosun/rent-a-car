package kodlama.io.rentacar.business.concretes;

import kodlama.io.rentacar.business.abstracts.InvoiceService;
import kodlama.io.rentacar.business.dto.requests.create.CreateInvoiceRequest;
import kodlama.io.rentacar.business.dto.requests.update.UpdateInvoiceRequest;
import kodlama.io.rentacar.business.dto.responses.create.CreateInvoiceResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetAllInvoiceResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetInvoiceResponse;
import kodlama.io.rentacar.business.dto.responses.update.UpdateInvoiceResponse;
import kodlama.io.rentacar.business.rules.InvoiceBusinessRules;
import kodlama.io.rentacar.entities.Invoice;
import kodlama.io.rentacar.repository.InvoiceRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InvoiceManager implements InvoiceService {
    private final InvoiceRepository repository;
    private final ModelMapper mapper;
    private final InvoiceBusinessRules rules;
    @Override
    public CreateInvoiceResponse add(CreateInvoiceRequest request) {
        Invoice invoice = mapper.map(request,Invoice.class);
        invoice.setId(0);
        repository.save(invoice);
        CreateInvoiceResponse response = mapper.map(invoice,CreateInvoiceResponse.class);
        return response;
    }

    @Override
    public UpdateInvoiceResponse update(int id,UpdateInvoiceRequest request) {
        rules.checkIfInvoiceExistsById(id);
        Invoice invoice = mapper.map(request,Invoice.class);
        invoice.setId(id);
        repository.save(invoice);
        UpdateInvoiceResponse response = mapper.map(invoice,UpdateInvoiceResponse.class);
        return response;
    }

    @Override
    public GetInvoiceResponse getById(int id) {
        rules.checkIfInvoiceExistsById(id);
        Invoice invoice = repository.findById(id).orElseThrow();
        GetInvoiceResponse response = mapper.map(invoice,GetInvoiceResponse.class);
        return response;
    }

    @Override
    public List<GetAllInvoiceResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(invoice -> mapper.map(invoice,GetAllInvoiceResponse.class))
                .toList();
    }

    @Override
    public void delete(int id) {
        rules.checkIfInvoiceExistsById(id);
        repository.deleteById(id);
    }

    @Override
    public void writeInvoice(CreateInvoiceRequest request) {
        Invoice invoice = mapper.map(request,Invoice.class);
        invoice.setId(0);
        repository.save(invoice);
    }

    //Business Rules

}
