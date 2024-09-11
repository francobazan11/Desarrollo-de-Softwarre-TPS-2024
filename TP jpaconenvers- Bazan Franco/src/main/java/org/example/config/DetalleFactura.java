package org.example.config;

import org.hibernate.envers.Audited;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Audited
@Entity
@Table(
        name = "detalle_factura"
)
public class DetalleFactura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column
    private int cantidad;
    @Column
    private int subtotal;
    @ManyToOne(
            cascade = {CascadeType.PERSIST}
    )
    @JoinColumn(
            name = "fk_factura"
    )
    private Factura factura;

    public static DetalleFacturaBuilder builder() {
        return new DetalleFacturaBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public int getSubtotal() {
        return this.subtotal;
    }

    public Factura getFactura() {
        return this.factura;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public String toString() {
        Long var10000 = this.getId();
        return "DetalleFactura(id=" + var10000 + ", cantidad=" + this.getCantidad() + ", subtotal=" + this.getSubtotal() + ", factura=" + this.getFactura() + ")";
    }

    public DetalleFactura(Long id, int cantidad, int subtotal, Factura factura) {
        this.id = id;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.factura = factura;
    }

    public DetalleFactura() {
    }

    public static class DetalleFacturaBuilder {
        private Long id;
        private int cantidad;
        private int subtotal;
        private Factura factura;

        DetalleFacturaBuilder() {
        }

        public DetalleFacturaBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public DetalleFacturaBuilder cantidad(int cantidad) {
            this.cantidad = cantidad;
            return this;
        }

        public DetalleFacturaBuilder subtotal(int subtotal) {
            this.subtotal = subtotal;
            return this;
        }

        public DetalleFacturaBuilder factura(Factura factura) {
            this.factura = factura;
            return this;
        }

        public DetalleFactura build() {
            return new DetalleFactura(this.id, this.cantidad, this.subtotal, this.factura);
        }

        public String toString() {
            return "DetalleFactura.DetalleFacturaBuilder(id=" + this.id + ", cantidad=" + this.cantidad + ", subtotal=" + this.subtotal + ", factura=" + this.factura + ")";
        }
    }
}
