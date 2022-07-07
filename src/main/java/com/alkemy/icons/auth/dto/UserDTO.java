package com.alkemy.icons.auth.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    
    @Email(message = "Username must be email")
    private String username;
    @Size(min = 8)
    private String password;

}
