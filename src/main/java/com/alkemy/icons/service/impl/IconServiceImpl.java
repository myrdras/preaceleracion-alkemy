package com.alkemy.icons.service.impl;

import com.alkemy.icons.dto.IconBasicDTO;
import com.alkemy.icons.dto.IconDTO;
import com.alkemy.icons.dto.IconFiltersDTO;
import com.alkemy.icons.entity.IconEntity;
import com.alkemy.icons.entity.PaisEntity;
import com.alkemy.icons.exception.ParamNotFound;
import com.alkemy.icons.mapper.IconMapper;
import com.alkemy.icons.repository.IconRepository;
import com.alkemy.icons.repository.specifications.IconSpecification;
import com.alkemy.icons.service.IconService;
import com.alkemy.icons.service.PaisService;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IconServiceImpl implements IconService{
    
    // Repo
    private IconRepository iconRepository;
    private IconSpecification iconSpecification;
    // Mapper
    private IconMapper iconMapper;
    // Service
    private PaisService paisService;
    
    @Autowired
    public IconServiceImpl(
            IconRepository iconRepository, 
            IconSpecification iconSpecification, 
            IconMapper iconMapper, 
            PaisService paisService) {
        this.iconRepository = iconRepository;
        this.iconSpecification = iconSpecification;
        this.iconMapper = iconMapper;
        this.paisService = paisService;
    }

    @Override
    public List<IconBasicDTO> getAll() {
        List<IconEntity> entities = this.iconRepository.findAll();
        List<IconBasicDTO> iconBasicDTOS = this.iconMapper.iconEntitySet2BasicDTOList(entities);
        return iconBasicDTOS;
    }

    @Override
    public IconDTO getDetailsById(Long id) {
        Optional<IconEntity> entity = this.iconRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound("Id icono no valido");
        }
        IconDTO icon = this.iconMapper.iconEntity2DTO(entity.get(), true);
        return icon;
    }

    @Override
    public List<IconDTO> getByFilters(String name, String date, Set<Long> cities, String order) {
        IconFiltersDTO filtersDTO = new IconFiltersDTO(name, date, cities, order);
        List<IconEntity> entities = this.iconRepository.findAll(this.iconSpecification.getByFilters(filtersDTO));
        List<IconDTO> dtos = this.iconMapper.iconEntitySet2DTOList(entities, true);
        return dtos;
    }

    @Override
    public IconDTO save(IconDTO dto) {
        IconEntity entity = this.iconMapper.iconDTO2Entity(dto);
        IconEntity entitySaved = this.iconRepository.save(entity);
        IconDTO result = this.iconMapper.iconEntity2DTO(entitySaved, false);
        return result;
    }

    @Override
    public IconDTO update(Long id, IconDTO icon) {
        Optional<IconEntity> entity = this.iconRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound("Id icono no valido");
        }
        this.iconMapper.iconEntityRefreshValues(entity.get(), icon);
        IconEntity entitySaved = this.iconRepository.save(entity.get());
        IconDTO result = this.iconMapper.iconEntity2DTO(entitySaved, false);
        return result;
    }

    @Override
    public void addPais(Long id, Long idPais) {
        IconEntity entity = this.iconRepository.getById(id);
        entity.getPaises().size();
        PaisEntity paisEntity = this.paisService.getEntityById(idPais);
        entity.addPais(paisEntity);
        this.iconRepository.save(entity);
    }

    @Override
    public void removePais(Long id, Long idPais) {
        IconEntity entity = this.iconRepository.getById(id);
        entity.getPaises().size();
        PaisEntity paisEntity = this.paisService.getEntityById(idPais);
        entity.removePais(paisEntity);
        this.iconRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        this.iconRepository.deleteById(id);
    }

}
