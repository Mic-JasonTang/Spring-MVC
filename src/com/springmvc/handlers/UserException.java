package com.springmvc.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Spring-MVC
 * <p>
 * Created by JasonTang on 1/15/2017 11:05 PM.
 */
@ResponseStatus(value = HttpStatus.BAD_GATEWAY, reason = "User Exception")
public class UserException extends RuntimeException{

}
