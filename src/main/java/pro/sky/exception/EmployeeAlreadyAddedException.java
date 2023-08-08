package pro.sky.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Пользователь уже добавлен")
public class EmployeeAlreadyAddedException extends RuntimeException {

     public EmployeeAlreadyAddedException(String message) {
        super(message);
    }
}
