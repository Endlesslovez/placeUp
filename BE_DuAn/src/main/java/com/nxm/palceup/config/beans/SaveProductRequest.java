package com.nxm.palceup.config.beans;

import com.nxm.palceup.entities.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SaveProductRequest {
    private Integer id;
    private String name;
    private int quantity;
    private List<MultipartFile> files;
    private BigDecimal price;
    private int status;
    private List<Image> listImage;
    private Category category;
    private Size size;
    private Color color;
    private Designs design;
    private Material material;
}
