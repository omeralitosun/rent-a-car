package kodlama.io.rentacar.adapters;

import kodlama.io.rentacar.business.abstracts.PosService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class FakePosServiceAdaptor implements PosService {
    @Override
    public void pay() {
        boolean isPaymentSuccesful = new Random().nextBoolean();
        if (!isPaymentSuccesful) throw new RuntimeException("Ödeme başarısız oldu.");
    }
}
