package be.epicode.buildWeek5.exceptions;

import lombok.Getter;

@Getter
public class UnauthorizedException extends RuntimeException{
    public UnauthorizedException(String message){
        super(message);
    }
}
