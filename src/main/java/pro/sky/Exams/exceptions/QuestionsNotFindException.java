package pro.sky.Exams.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuestionsNotFindException extends RuntimeException {
    public QuestionsNotFindException() {
    }

    public QuestionsNotFindException(String message) {
        super(message);
    }

    public QuestionsNotFindException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuestionsNotFindException(Throwable cause) {
        super(cause);
    }

    public QuestionsNotFindException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
