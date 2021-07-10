package com.dal.universityPortal.exceptions;

import java.util.List;

public class ValidationException extends Exception {
    List<String> errors;

    public ValidationException(List<String> errors){
        super();
        this.errors = errors;
    }

    public List<String> getErrors(){
        return errors;
    }
}
