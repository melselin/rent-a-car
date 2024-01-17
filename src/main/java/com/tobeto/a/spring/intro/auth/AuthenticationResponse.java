package com.tobeto.a.spring.intro.auth;
import lombok.*;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    private String  token;
}
