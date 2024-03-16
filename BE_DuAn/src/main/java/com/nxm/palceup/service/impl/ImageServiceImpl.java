package com.nxm.palceup.service.impl;

import com.nxm.palceup.entities.Image;
import com.nxm.palceup.entities.Product;
import com.nxm.palceup.repositories.ImageRepository;
import com.nxm.palceup.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageRepository imageRepository;


    @Override
    public List<Image> findAll() {
        return imageRepository.findAll();
    }


    @Override
    public Image create(Image images) {
        return imageRepository.save(images);
    }

    @Override
    public Image update(Image images, Integer id) {
        Optional<Image> optional = findById(id);
        if (optional.isPresent()) {
            Image existingImage = optional.get();
            existingImage.setUrlimage(images.getUrlimage());
            return create(existingImage);
        }
        return null;
    }

    @Override
    public Image delete(Integer id) {
        Image image =imageRepository.findById(id).get();
        imageRepository.delete(image);
        return image;
    }

    @Override
    public List<Image> findByProduct(Product product) {

        return imageRepository.findByProduct(product);
    }

    @Override
    public List<Image> createList(List<Image> images) {
        return imageRepository.saveAll(images);
    }

    @Override
    public Optional<Image> findById(Integer id) {
        return imageRepository.findById(id);
    }

    @Override
    public List<Image> findImageByPr(Integer id) {
        if (id == null){
            return null;
        }
        return imageRepository.findImageByPr(id);
    }

    @Override
    public List<Image> selectByIdProduct(Integer id) {
        return imageRepository.selectByIdProduct(id);
    }


}
