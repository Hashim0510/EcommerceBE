package hashim.projects.ecommerce.productservice.Exceptions;

import org.springframework.http.HttpStatus;

public class ExceptionResponse {

    private HttpStatus httpStatus;
    private String message;

    public ExceptionResponse(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
