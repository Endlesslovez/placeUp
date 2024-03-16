package com.nxm.palceup.service.impl;

import com.nxm.palceup.entities.Color;
import com.nxm.palceup.repositories.ColorRepository;
import com.nxm.palceup.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ColorServiceImpl implements ColorService {

    @Autowired
    private ColorRepository colorRepository;

    @Override
    public List<Color> getAll() {
        return colorRepository.findAll();
    }

    @Override
    public Color create(Color color) {
        return colorRepository.save(color);
    }

    @Override
    public Color getColorByID(Integer id) {
        return  colorRepository.findColorByIdColor(id);
    }

    @Override
    public Color update(Color color) {
        return colorRepository.save(color);
    }

    @Override
    public void delete(Integer id) {
        colorRepository.deleteById(id);
    }

    @Override
    public Color getNameColor(String name) {
        return colorRepository.getNameColor(name);
    }
}
