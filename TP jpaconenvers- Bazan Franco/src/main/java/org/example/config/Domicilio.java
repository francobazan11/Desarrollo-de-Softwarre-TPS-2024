package org.example.config;

import org.hibernate.envers.Audited;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Audited
@Entity
@Table(
        name = "domicilio"
)
public class Domicilio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column
    private String nombrecalle;
    @Column
    private int numero;
    @OneToOne(
            mappedBy = "domicilio"
    )
    private Cliente cliente;

    public static DomicilioBuilder builder() {
        return new DomicilioBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public String getNombrecalle() {
        return this.nombrecalle;
    }

    public int getNumero() {
        return this.numero;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombrecalle(String nombrecalle) {
        this.nombrecalle = nombrecalle;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String toString() {
        Long var10000 = this.getId();
        return "Domicilio(id=" + var10000 + ", nombrecalle=" + this.getNombrecalle() + ", numero=" + this.getNumero() + ", cliente=" + this.getCliente() + ")";
    }

    public Domicilio(Long id, String nombrecalle, int numero, Cliente cliente) {
        this.id = id;
        this.nombrecalle = nombrecalle;
        this.numero = numero;
        this.cliente = cliente;
    }

    public Domicilio() {
    }

    public static class DomicilioBuilder {
        private Long id;
        private String nombrecalle;
        private int numero;
        private Cliente cliente;

        DomicilioBuilder() {
        }

        public DomicilioBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public DomicilioBuilder nombrecalle(String nombrecalle) {
            this.nombrecalle = nombrecalle;
            return this;
        }

        public DomicilioBuilder numero(int numero) {
            this.numero = numero;
            return this;
        }

        public DomicilioBuilder cliente(Cliente cliente) {
            this.cliente = cliente;
            return this;
        }

        public Domicilio build() {
            return new Domicilio(this.id, this.nombrecalle, this.numero, this.cliente);
        }

        public String toString() {
            return "Domicilio.DomicilioBuilder(id=" + this.id + ", nombrecalle=" + this.nombrecalle + ", numero=" + this.numero + ", cliente=" + this.cliente + ")";
        }
    }
}
