package com.br.workshopmongo.workshopmongo.component;


import lombok.Getter;
import lombok.ToString;
import sun.net.www.content.text.Generic;


@Getter
@ToString
public class GenericException extends RuntimeException {

    public GenericException(String message){
        super(message);
    }
}
