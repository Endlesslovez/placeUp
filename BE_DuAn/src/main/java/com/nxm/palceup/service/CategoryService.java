package com.nxm.palceup.service;

import com.nxm.palceup.entities.Category;

public interface CategoryService  extends GenericService<Category, Integer>{
    Category getNameCategory(String name);
    public Category update(Category category);

}
