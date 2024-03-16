package com.nxm.palceup.repositories;

import com.nxm.palceup.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeRepository extends JpaRepository<Size, Integer> {
    @Query(" SELECT s FROM Size s WHERE s.name like %?1% ")
    Size getNameSize(String name);
}
