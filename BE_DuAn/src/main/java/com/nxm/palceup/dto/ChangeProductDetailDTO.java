package com.nxm.palceup.dto;

import com.nxm.palceup.entities.Bill_detail;
import com.nxm.palceup.entities.Product;
import com.nxm.palceup.entities.ProductChange;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChangeProductDetailDTO {
    private Integer idChangeDetail;
    private Product product;
    private Bill_detail bill_detail;
    private ProductChange productChange;
}
