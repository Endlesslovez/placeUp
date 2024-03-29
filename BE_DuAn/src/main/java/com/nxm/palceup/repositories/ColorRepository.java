package com.nxm.palceup.repositories;

import com.nxm.palceup.entities.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends JpaRepository<Color, Integer> {

    Color findColorByIdColor(Integer id);
    @Query(" SELECT s FROM Color s WHERE s.name like %?1% ")
    Color getNameColor(String name);

}
