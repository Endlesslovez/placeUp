package com.nxm.palceup.dto;

import com.nxm.palceup.entities.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponDTO {
    private Integer idProduct;
    private String name;
    private String image;
    private BigDecimal price;
    private Integer total;
    private String note;
    private int status;
    private Color color;
    private Material material;
    private Designs designs;
    private Size size;
    private Category category;

}
