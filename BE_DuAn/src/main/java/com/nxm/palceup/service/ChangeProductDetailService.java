package com.nxm.palceup.service;

import com.nxm.palceup.entities.ChangeProductDetail;
import com.nxm.palceup.entities.ProductChange;

public interface ChangeProductDetailService extends GenericService<ChangeProductDetail, Integer>{
    public void createChangeDetails(Integer id);

    public ChangeProductDetail findPrChangeDetails(ProductChange idPrChange);
}
