package com.nxm.palceup.dto;

import lombok.Data;

@Data
public class UpdatePasswordDTO {
    private String oldPassword;
    private String password;
}
