package com.nxm.palceup.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AccountDTO {
    private String username;
    private String fullName;
    private Boolean gender;
    private String email;
    private String phone;
}
