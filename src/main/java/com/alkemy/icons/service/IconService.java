package com.alkemy.icons.service;

import com.alkemy.icons.dto.IconBasicDTO;
import com.alkemy.icons.dto.IconDTO;
import java.util.List;
import java.util.Set;

public interface IconService {
    
    List<IconBasicDTO> getAll();
    
    IconDTO getDetailsById(Long id);
    
    List<IconDTO> getByFilters(String name, String date, Set<Long> cities, String order);
    
    IconDTO save(IconDTO dto);
    
    IconDTO update(Long id, IconDTO icon);
    
    void delete(Long id);

}
