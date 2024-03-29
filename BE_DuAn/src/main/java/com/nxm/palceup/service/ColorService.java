package com.nxm.palceup.service;

import com.nxm.palceup.entities.Color;

import java.util.List;

public interface ColorService {
    public List<Color> getAll();

    public Color create(Color color);

    public Color getColorByID(Integer id);

    public Color update(Color color);

    public void delete(Integer id);
    Color getNameColor(String name);
}
