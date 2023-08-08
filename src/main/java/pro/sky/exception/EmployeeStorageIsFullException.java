package pro.sky.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INSUFFICIENT_STORAGE, reason = "Cписок заполнен")
public class EmployeeStorageIsFullException extends RuntimeException {

     public EmployeeStorageIsFullException(String message) {
        super(message);
    }
}
