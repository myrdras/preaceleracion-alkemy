package com.alkemy.icons.service.impl;

import com.alkemy.icons.dto.IconBasicDTO;
import com.alkemy.icons.dto.IconDTO;
import com.alkemy.icons.repository.IconRepository;
import com.alkemy.icons.service.IconService;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;

public class IconServiceImpl implements IconService{
    
    @Autowired
    private IconRepository iconRepository;

    @Override
    public List<IconBasicDTO> getAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public IconDTO getDetailsById(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<IconDTO> getByFilters(String name, String date, Set<Long> cities, String order) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public IconDTO save(IconDTO dto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public IconDTO update(Long id, IconDTO icon) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Long id) {
        this.iconRepository.deleteById(id);
    }

}
