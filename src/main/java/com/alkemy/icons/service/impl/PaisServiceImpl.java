package com.alkemy.icons.service.impl;

import com.alkemy.icons.dto.PaisBasicDTO;
import com.alkemy.icons.dto.PaisDTO;
import com.alkemy.icons.entity.PaisEntity;
import com.alkemy.icons.exception.ParamNotFound;
import com.alkemy.icons.mapper.PaisMapper;
import com.alkemy.icons.repository.PaisRepository;
import com.alkemy.icons.service.PaisService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaisServiceImpl implements PaisService{
    
    @Autowired
    private PaisMapper paisMapper;
    @Autowired
    private PaisRepository paisRepository;

    @Override
    public List<PaisBasicDTO> getAllBasic() {
        List<PaisEntity> entities = paisRepository.findAll();
        List<PaisBasicDTO> dtos = paisMapper.paisBasicListEntity2DTO(entities);
        return dtos;
    }

    @Override
    public PaisEntity getEntityById(Long idPais) {
        Optional<PaisEntity> entity = paisRepository.findById(idPais);
        if (!entity.isPresent()) {
            throw new ParamNotFound("Id pais no valido");
        }
        PaisEntity pais = entity.get();
        return pais;
    }

    @Override
    public PaisDTO save(PaisDTO dto) {
        PaisEntity entity = paisMapper.paisDTO2Entity(dto);
        PaisEntity entitySaved = paisRepository.save(entity);
        PaisDTO result = paisMapper.paisEntity2DTO(entitySaved, false);
        return result;
    }

    @Override
    public PaisDTO update(Long id, PaisDTO dto) {
        Optional<PaisEntity> entity = paisRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound("Id pais no valido");
        }
        paisMapper.paisEntityRefreshValues(entity.get(), dto);
        PaisEntity entitySaved = paisRepository.save(entity.get());
        PaisDTO result = paisMapper.paisEntity2DTO(entitySaved, false);
        return result;
    }

}
