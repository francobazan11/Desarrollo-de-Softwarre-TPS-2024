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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Audited
@Entity
@Table(
        name = "factura"
)
public class Factura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column
    private String fecha;
    @Column
    private int numero;
    @ManyToOne(
            cascade = {CascadeType.PERSIST}
    )
    @JoinColumn(
            name = "fk_cliente"
    )
    private Cliente cliente;
    @Column
    private int total;
    @OneToMany(
            mappedBy = "factura",
            cascade = {CascadeType.ALL},
            orphanRemoval = true
    )
    private List<DetalleFactura> detalles = new ArrayList();

    public static FacturaBuilder builder() {
        return new FacturaBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public String getFecha() {
        return this.fecha;
    }

    public int getNumero() {
        return this.numero;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public int getTotal() {
        return this.total;
    }

    public List<DetalleFactura> getDetalles() {
        return this.detalles;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setDetalles(List<DetalleFactura> detalles) {
        this.detalles = detalles;
    }

    public String toString() {
        Long var10000 = this.getId();
        return "Factura(id=" + var10000 + ", fecha=" + this.getFecha() + ", numero=" + this.getNumero() + ", cliente=" + this.getCliente() + ", total=" + this.getTotal() + ", detalles=" + this.getDetalles() + ")";
    }

    public Factura(Long id, String fecha, int numero, Cliente cliente, int total, List<DetalleFactura> detalles) {
        this.id = id;
        this.fecha = fecha;
        this.numero = numero;
        this.cliente = cliente;
        this.total = total;
        this.detalles = detalles;
    }

    public Factura() {
    }

    public static class FacturaBuilder {
        private Long id;
        private String fecha;
        private int numero;
        private Cliente cliente;
        private int total;
        private List<DetalleFactura> detalles;

        FacturaBuilder() {
        }

        public FacturaBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public FacturaBuilder fecha(String fecha) {
            this.fecha = fecha;
            return this;
        }

        public FacturaBuilder numero(int numero) {
            this.numero = numero;
            return this;
        }

        public FacturaBuilder cliente(Cliente cliente) {
            this.cliente = cliente;
            return this;
        }

        public FacturaBuilder total(int total) {
            this.total = total;
            return this;
        }

        public FacturaBuilder detalles(List<DetalleFactura> detalles) {
            this.detalles = detalles;
            return this;
        }

        public Factura build() {
            return new Factura(this.id, this.fecha, this.numero, this.cliente, this.total, this.detalles);
        }

        public String toString() {
            return "Factura.FacturaBuilder(id=" + this.id + ", fecha=" + this.fecha + ", numero=" + this.numero + ", cliente=" + this.cliente + ", total=" + this.total + ", detalles=" + this.detalles + ")";
        }
    }
}