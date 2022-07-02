package com.alkemy.icons.service;

import com.alkemy.icons.dto.PaisBasicDTO;
import com.alkemy.icons.dto.PaisDTO;
import com.alkemy.icons.entity.PaisEntity;
import java.util.List;

public interface PaisService {
    
    List<PaisBasicDTO> getAllBasic();
    
    PaisEntity getEntityById(Long id);
    
    PaisDTO save(PaisDTO dto);
    
    PaisDTO update(Long id, PaisDTO dto);

}
