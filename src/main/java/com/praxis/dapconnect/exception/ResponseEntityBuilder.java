package com.praxis.dapconnect.exception;

import com.praxis.dapconnect.model.FailureResponse;
import org.springframework.http.ResponseEntity;

public class ResponseEntityBuilder {

    public static ResponseEntity<Object> build(FailureResponse failureResponse) {
        return new ResponseEntity<>(failureResponse, failureResponse.getStatus());
    }

}
