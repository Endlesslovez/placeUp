package com.nxm.palceup.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    private Integer idCategory;
    @NotEmpty(message = "Tên sản phẩm không được để trống")
    private String name;

    private Integer type;

    private Integer status;


}
