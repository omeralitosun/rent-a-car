package kodlama.io.rentacar.business.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequest {
    @NotBlank(message = "Kart numarası alanı boş bırakılamaz")
    @Length(min = 16,max = 16, message = "Kart Numarası 16 haneden oluşmalıdır.")
    private String cardNumber;

    @NotBlank(message = "Kart sahibi bilgisi boş bırakılamaz")
    @Length(min = 5,message = "Kart sahibi bilgisi en az 5 karakterden oluşmalıdır")
    private String cardHolder;

    @NotNull(message = "Kartın son kullanma yılı boş bırakılamaz")
    @Min(value = 2023,message = "Kartın son kullanma yılı geçersiz")
    private int cardExpirationYear;

    @NotNull
    @Min(value = 1)
    @Max(value = 12)
    private int cardExpirationMonth;

    @NotBlank
    @Length(min = 3,max = 3)
    private String cardCvv;
}
