package com.alkemy.icons.repository;

import com.alkemy.icons.entity.IconEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IconRepository extends JpaRepository<IconEntity, Long>{

}
