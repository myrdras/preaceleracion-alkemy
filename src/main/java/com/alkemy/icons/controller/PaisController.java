package com.alkemy.icons.controller;

import com.alkemy.icons.dto.PaisBasicDTO;
import com.alkemy.icons.dto.PaisDTO;
import com.alkemy.icons.entity.PaisEntity;
import com.alkemy.icons.service.PaisService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("paises")
public class PaisController {
    
    @Autowired
    private PaisService paisService;
    
    @GetMapping("/all")
    public ResponseEntity<List<PaisBasicDTO>> getAll() {
        List<PaisBasicDTO> icons = paisService.getAllBasic();
        return ResponseEntity.ok(icons);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<PaisEntity> getEntityById(@PathVariable Long id) {
        PaisEntity icon = paisService.getEntityById(id);
        return ResponseEntity.ok(icon);
    }
    
    @PostMapping
    public ResponseEntity<PaisDTO> save(@RequestBody PaisDTO icon) {
        PaisDTO result = paisService.save(icon);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<PaisDTO> update(@PathVariable Long id, @RequestBody PaisDTO icon) {
        PaisDTO result = paisService.update(id, icon);
        return ResponseEntity.ok(result);
    }

}
