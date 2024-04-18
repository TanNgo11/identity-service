package com.thanhtan.identityservice.dto.response;


import com.thanhtan.identityservice.dto.AbstractDTO;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@SuperBuilder
public class UserResponse extends AbstractDTO<UserResponse> {

    String username;
    String firstName;
    String lastName;
    LocalDate dob;

    Set<RoleResponse> roles;



}