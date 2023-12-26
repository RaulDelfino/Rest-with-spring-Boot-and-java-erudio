package br.com.erudio.Exceptions;

import java.io.Serializable;
import java.util.Date;

public class ExceptionsResponse implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private Date timestamp;
    private String message;
    private String details;


    public ExceptionsResponse(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return this.details;
    }

    public void setDetails(String details) {
        this.details = details;
    }


}
