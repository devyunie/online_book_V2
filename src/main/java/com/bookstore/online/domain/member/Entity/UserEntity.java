package com.bookstore.online.domain.member.Entity;

import com.bookstore.online.domain.member.dto.request.SignUpRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="users")
@Table(name="users")
public class UserEntity {
    @Id
    private String userId;
    private String name;
    private String password;
    private String email;

    public UserEntity(SignUpRequestDto dto){
        this.userId = dto.getUserId();
        this.name = dto.getName();
        this.password = dto.getPassword();
        this.email = dto.getEmail();
    }
}

