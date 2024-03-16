package com.nxm.palceup.repositories;

import com.nxm.palceup.entities.ChangeProductDetail;
import com.nxm.palceup.entities.ProductChange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ChangeProductDetailRepository extends JpaRepository<ChangeProductDetail, Integer> {
    @Modifying
    @Query(value = "insert into change_product_detail(id_bill_detail,id_change_product) values(?1," +
            "(select id_change_product from change_product order by id_change_product  desc limit 1))",nativeQuery = true)
    void createChangeDetails(Integer id);

    @Query("select prChangeDetail from ChangeProductDetail  prChangeDetail where prChangeDetail.changeProduct = ?1")
    public ChangeProductDetail findPrChangeDetails(ProductChange idPrChange);
}
