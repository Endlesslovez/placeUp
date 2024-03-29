package com.nxm.palceup.repositories;

import com.nxm.palceup.entities.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Integer> {

    @Query(" SELECT s FROM Material s WHERE s.name like %?1% ")
    Material getNameMaterial(String name);
}
