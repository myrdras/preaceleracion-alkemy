package com.alkemy.icons.service.impl;

import com.alkemy.icons.dto.ContinenteDTO;
import com.alkemy.icons.entity.ContinenteEntity;
import com.alkemy.icons.mapper.ContinenteMapper;
import com.alkemy.icons.repository.ContinenteRepository;
import com.alkemy.icons.service.ContinenteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContinenteServiceImpl implements ContinenteService {
    
    @Autowired
    private ContinenteMapper continenteMapper;
    @Autowired
    private ContinenteRepository continenteRepository;
    
    public ContinenteDTO save(ContinenteDTO dto) {
        ContinenteEntity entity = continenteMapper.continenteDTO2Entity(dto);
        ContinenteEntity entitySaved = continenteRepository.save(entity);
        ContinenteDTO result = continenteMapper.continenteEntity2DTO(entitySaved);
        return result;
    }
    
    public List<ContinenteDTO> getAllContinentes() {
        List<ContinenteEntity> entities = continenteRepository.findAll();
        List<ContinenteDTO> result = continenteMapper.continenteEntityList2DTOList(entities);
        return result;
    }
    
}
