package com.nxm.palceup.service.impl;

import com.nxm.palceup.entities.Material;
import com.nxm.palceup.repositories.MaterialRepository;
import com.nxm.palceup.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialServiceImpl implements MaterialService {
    @Autowired
    private MaterialRepository materialRepository;
    @Override
    public List<Material> getAll() {
        return materialRepository.findAll();
    }

    @Override
    public Material create(Material material) {
        return materialRepository.save(material);
    }

    @Override
    public Optional<Material> getMaterialByID(Integer id) {
         return materialRepository.findById(id);
    }

    @Override
    public Material update(Material material) {
        return materialRepository.save(material);
    }

    @Override
    public void delete(Integer id) {
        materialRepository.deleteById(id);
    }

    @Override
    public Material getNameMaterial(String name) {
        return materialRepository.getNameMaterial(name);
    }
}
