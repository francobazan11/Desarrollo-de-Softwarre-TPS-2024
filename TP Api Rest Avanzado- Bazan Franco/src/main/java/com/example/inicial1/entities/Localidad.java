package com.example.inicial1.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Table(name="localidad")
@Audited
public class Localidad extends Base{
    @Column
    private String denominacion;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="fk_domicilio")
    private Domicilio domicilio;

    @OneToMany(cascade= CascadeType.ALL, orphanRemoval=true)
    @JoinTable(
            name="persona_libro",
            joinColumns = @JoinColumn(name="persona_id"),
            inverseJoinColumns = @JoinColumn(name="libro_id")

    )
    private List<Libro> libros= new ArrayList<Libro>();
}
