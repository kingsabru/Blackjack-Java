package com.company;

import java.security.InvalidParameterException;

public class InvalidPlayerNumberException extends InvalidParameterException {
    public InvalidPlayerNumberException(){
        System.out.println("Invalid input. Players must be greater than 1 but less than or equal to 6.\n");
    }

//    @Override
//    public String getMessage() {
//        return super.getMessage();
//    }
}
