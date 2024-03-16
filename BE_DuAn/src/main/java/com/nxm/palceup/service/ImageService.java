package com.nxm.palceup.service;

import com.nxm.palceup.entities.Image;
import com.nxm.palceup.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ImageService {
    public List<Image> findAll();

    /**
     * Lấy image theo id
     *
     * @param id
     * @return
     */
    /**
     * Thêm mới image
     *
     * @param images
     * @return
     */
    public Image create(Image images);

    /**
     * Cập nhật image
     *
     * @param images
     * @return
     */
    public Image update(Image images, Integer id);

    /**
     * Xoá image theo id
     *
     * @param id
     * @return
     */
    public Image delete(Integer id);


    public List<Image> findByProduct(Product product);

    /**
     * Tạo list image
     * @param images
     * @return
     */
    public List<Image> createList(List<Image> images);

    Optional<Image> findById(Integer id);

    public List<Image> findImageByPr(Integer id);
    List<Image> selectByIdProduct(Integer id);
}
