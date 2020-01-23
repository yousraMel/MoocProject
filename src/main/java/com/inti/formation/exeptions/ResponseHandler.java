package com.inti.formation.exeptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@ResponseStatus

public class ResponseHandler {

    private Date timestamp;
    private int status;
    private Object message;
    private String path;

    public ResponseHandler(HttpStatus status, Object message) {
        this.timestamp = new Date();
        this.status = status.value();
        this.message = message;
        this.path = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getRequestURL().toString();
    }

	public ResponseHandler() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Object getMessage() {
		return message;
	}

	public void setMessage(Object message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "ResponseHandler [timestamp=" + timestamp + ", status=" + status + ", message=" + message + ", path="
				+ path + "]";
	}
    
    
}
