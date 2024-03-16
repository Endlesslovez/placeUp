package com.nxm.palceup.service;

import com.nxm.palceup.entities.Role;

import java.util.List;

public interface RoleService {
    public List<Role> getAll();

    public Role create(Role role);

    public Role getRoleByID(Long id);

    public Role update(Role role);

    public void delete(Long id);
}
