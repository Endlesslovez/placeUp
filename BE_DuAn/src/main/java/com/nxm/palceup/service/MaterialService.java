package com.nxm.palceup.service;

import com.nxm.palceup.entities.Material;

import java.util.List;
import java.util.Optional;

public interface MaterialService {
    public List<Material> getAll();

    public Material create(Material material);

    public Optional<Material> getMaterialByID(Integer id);

    public Material update(Material material);

    public void delete(Integer id);
    Material getNameMaterial(String name);
}
