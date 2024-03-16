package com.nxm.palceup.dto;

import com.nxm.palceup.entities.Account;
import com.nxm.palceup.entities.Bill_detail;
import com.nxm.palceup.entities.ChangeProductDetail;
import com.nxm.palceup.entities.Image;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductChangeDTO {
    private Integer idChange;
    private Date dateChange;
    private String description;
    private String email;
    private String phone;
    private Boolean status;
    private int  quantityProductChange;
    private Account account;
    private List<ChangeProductDetail> changeDetails;
    private List<Image> listImage;
    private List<MultipartFile> files;
    private Bill_detail bill_detail;
}
