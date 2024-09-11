package org.example.config;

import org.hibernate.envers.Audited;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Audited
@Entity
@Table(
        name = "cliente"
)
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(
            name = "nombre"
    )
    private String nombre;
    @Column(
            name = "apellido"
    )
    private String apellido;
    @Column(
            name = "dni",
            unique = true
    )
    private int dni;
    @OneToOne(
            cascade = {CascadeType.ALL}
    )
    @JoinColumn(
            name = "fk_domicilio"
    )
    private Domicilio domicilio;
    @OneToMany(
            mappedBy = "cliente"
    )
    private List<Factura> facturas = new ArrayList();

    public static ClienteBuilder builder() {
        return new ClienteBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public int getDni() {
        return this.dni;
    }

    public Domicilio getDomicilio() {
        return this.domicilio;
    }

    public List<Factura> getFacturas() {
        return this.facturas;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    public String toString() {
        Long var10000 = this.getId();
        return "Cliente(id=" + var10000 + ", nombre=" + this.getNombre() + ", apellido=" + this.getApellido() + ", dni=" + this.getDni() + ", domicilio=" + this.getDomicilio() + ", facturas=" + this.getFacturas() + ")";
    }

    public Cliente(Long id, String nombre, String apellido, int dni, Domicilio domicilio, List<Factura> facturas) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.domicilio = domicilio;
        this.facturas = facturas;
    }

    public Cliente() {
    }

    public static class ClienteBuilder {
        private Long id;
        private String nombre;
        private String apellido;
        private int dni;
        private Domicilio domicilio;
        private List<Factura> facturas;

        ClienteBuilder() {
        }

        public ClienteBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public ClienteBuilder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public ClienteBuilder apellido(String apellido) {
            this.apellido = apellido;
            return this;
        }

        public ClienteBuilder dni(int dni) {
            this.dni = dni;
            return this;
        }

        public ClienteBuilder domicilio(Domicilio domicilio) {
            this.domicilio = domicilio;
            return this;
        }

        public ClienteBuilder facturas(List<Factura> facturas) {
            this.facturas = facturas;
            return this;
        }

        public Cliente build() {
            return new Cliente(this.id, this.nombre, this.apellido, this.dni, this.domicilio, this.facturas);
        }

        public String toString() {
            return "Cliente.ClienteBuilder(id=" + this.id + ", nombre=" + this.nombre + ", apellido=" + this.apellido + ", dni=" + this.dni + ", domicilio=" + this.domicilio + ", facturas=" + this.facturas + ")";
        }
    }
}
