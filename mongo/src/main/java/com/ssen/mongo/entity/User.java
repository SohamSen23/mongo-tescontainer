package com.ssen.mongo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@AllArgsConstructor
public class User {
    @Id
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
}
