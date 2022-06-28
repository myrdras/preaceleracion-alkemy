package com.alkemy.icons.service;

import com.alkemy.icons.dto.PaisDTO;
import com.alkemy.icons.entity.PaisEntity;
import java.util.List;

public interface PaisService {
    
    List<PaisDTO> getAllPaises();
    
    PaisEntity getEntityById(Long idPais);
    
    PaisDTO save(PaisDTO dto);

}
