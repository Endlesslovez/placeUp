package com.nxm.palceup.restcontrollers.admin;

import com.nxm.palceup.entities.Material;
import com.nxm.palceup.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/material")
public class MaterialRestController {
    @Autowired
    private MaterialService materialService;

    @GetMapping()
    public List<Material> getAll() {
        return materialService.getAll();
    }

    @PostMapping
    public Material create(@RequestBody Material material) {
        return materialService.create(material);
    }

    @PutMapping("{id}")
    public Material update(@PathVariable("id") Integer id, @RequestBody Material material) {
//        material.setId_materials(id);
        return materialService.update(material);
    }
    @PutMapping("/delete")
    public Material updateDelete(@RequestBody Material material) {
        material.setStatus(0);
        return materialService.update(material);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id) {
        materialService.delete(id);
    }
    @GetMapping("{name}")
    public Material getNameMaterial(@PathVariable("name") String name) {
        return materialService.getNameMaterial(name);
    }
}
