package com.alkemy.icons.repository;

import com.alkemy.icons.entity.IconEntity;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface IconRepository extends JpaRepository<IconEntity, Long>, JpaSpecificationExecutor<IconEntity> {
    
    List<IconEntity> findAll(Specification<IconEntity> spec);

}
