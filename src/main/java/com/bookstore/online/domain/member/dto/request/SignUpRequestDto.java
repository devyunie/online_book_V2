package com.bookstore.online.domain.member.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequestDto {
    @NotBlank
    private String userId;
    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotBlank
    @Pattern(regexp = "^(?=.*[a-zA-z])(?=.*[0-9]).{8,13}$")
    private String password;
}
