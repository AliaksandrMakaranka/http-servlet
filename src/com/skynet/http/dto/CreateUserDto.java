package com.skynet.http.dto;

import com.skynet.http.entity.Gender;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateUserDto {
    String name;
    String birthday;
    String email;
    String password;
    String role;
    String gender;
}
