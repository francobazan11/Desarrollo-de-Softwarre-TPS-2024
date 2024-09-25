package com.example.inicial1.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Table(name="domicilio")
@Audited
public class Domicilio extends Base{

    @Column
    private String calle;
    @Column
    private int numero;

    @ManyToOne(optional=false)
    @JoinColumn(name="fk_localidad")
    private Localidad localidad;
}
