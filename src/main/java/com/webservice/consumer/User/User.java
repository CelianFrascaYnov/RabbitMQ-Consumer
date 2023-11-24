package com.webservice.consumer.User;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class User implements Serializable {
    private String name;
    private String email;
    private String verificationToken;
}
