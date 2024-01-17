package com.tobeto.a.spring.intro.auth;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String firstname;
    private String lastname;
    private int age;
    private String email;
    private String password;

    public String getFirstName() {
    }

    public String getLastName() {
    }
}
