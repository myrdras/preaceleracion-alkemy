package com.alkemy.icons.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "icon")
@Getter
@Setter
public class IconEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    private String imagen;
    
    private String denominacion;
    
    @Column(name = "fecha_creacion")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate fechaCreacion;
    
    private Long altura;
    
    private String historia;
    
    private boolean deleted = Boolean.FALSE;
    
//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinColumn(name = "pais_id")
//    private PaisEntity pais;
    
    @ManyToMany(mappedBy = "icons", cascade = CascadeType.ALL)
    private List<PaisEntity> paises = new ArrayList<>();
    
    // Add and remove pais
    public void addPais(PaisEntity pais) { this.paises.add(pais); }
    public void removePais(PaisEntity pais) { this.paises.remove(pais); }
    
}