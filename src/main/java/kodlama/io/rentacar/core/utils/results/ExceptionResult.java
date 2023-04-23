package kodlama.io.rentacar.core.utils.results;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ExceptionResult<T> {
    private LocalDateTime timeStamp;
    private String type;
    private T message;

    public ExceptionResult(String type, T message){
        timeStamp = LocalDateTime.now();
        this.type = type;
        this.message = message;
    }
}
