package com.alkemy.icons.mapper;

import com.alkemy.icons.dto.IconDTO;
import com.alkemy.icons.dto.PaisDTO;
import com.alkemy.icons.entity.IconEntity;
import com.alkemy.icons.entity.PaisEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaisMapper {
    
    @Autowired
    private IconMapper iconMapper;
    
    public PaisEntity paisDTO2Entity(PaisDTO dto) {
        PaisEntity entity = new PaisEntity();
        entity.setImagen(dto.getImagen());
        entity.setDenominacion(dto.getDenominacion());
        entity.setCantidadHabitantes(dto.getCantidadHabitantes());
        entity.setSuperficie(dto.getSuperficie());
        entity.setContinenteId(dto.getContinenteId());
        // icons
        Set<IconEntity> icons = this.iconMapper.iconDTOList2Entity(dto.getIcons());
        entity.setIcons(icons);
        return entity;
    }
    
    public PaisDTO paisEntity2DTO(PaisEntity entity, boolean loadPaises) {
        PaisDTO dto = new PaisDTO();
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setDenominacion(entity.getDenominacion());
        dto.setCantidadHabitantes(entity.getCantidadHabitantes());
        dto.setSuperficie(entity.getSuperficie());
        dto.setContinenteId(entity.getContinenteId());
        if (loadPaises) {
            List<IconDTO> iconsDTO = this.iconMapper.iconEntitySet2DTOList(entity.getIcons(), false);
            dto.setIcons(iconsDTO);
        }
        return dto;
    }
    
    public List<PaisDTO> paisEntityList2DTOList(List<PaisEntity> entities, boolean loadIcons) {
        List<PaisDTO> dtos = new ArrayList<>();
        for (PaisEntity entity : entities) {
            dtos.add(this.paisEntity2DTO(entity, loadIcons));
        }
        return dtos;
    }
    
    public List<PaisEntity> paisDTOList2Entity(List<PaisDTO> dtos) {
        List<PaisEntity> entities = new ArrayList<>();
        for (PaisDTO dto : dtos) {
            entities.add(this.paisDTO2Entity(dto));
        }
        return entities;
    }

}
