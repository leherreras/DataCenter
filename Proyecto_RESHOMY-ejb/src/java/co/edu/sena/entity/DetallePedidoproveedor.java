

package co.edu.sena.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;



@Entity
@Table(name = "detalle_pedidoproveedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetallePedidoproveedor.findAll", query = "SELECT d FROM DetallePedidoproveedor d"),
    @NamedQuery(name = "DetallePedidoproveedor.findByIdDetallePedidoProveedor", query = "SELECT d FROM DetallePedidoproveedor d WHERE d.idDetallePedidoProveedor = :idDetallePedidoProveedor"),
    @NamedQuery(name = "DetallePedidoproveedor.findByPrecioProductoUnidad", query = "SELECT d FROM DetallePedidoproveedor d WHERE d.precioProductoUnidad = :precioProductoUnidad"),
    @NamedQuery(name = "DetallePedidoproveedor.findByCantidad", query = "SELECT d FROM DetallePedidoproveedor d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "DetallePedidoproveedor.findByDescuento", query = "SELECT d FROM DetallePedidoproveedor d WHERE d.descuento = :descuento"),
    @NamedQuery(name = "DetallePedidoproveedor.findByEntregado", query = "SELECT d FROM DetallePedidoproveedor d WHERE d.entregado = :entregado"),
    @NamedQuery(name = "DetallePedidoproveedor.findByFechaPedidoProveedor", query = "SELECT d FROM DetallePedidoproveedor d WHERE d.fechaPedidoProveedor = :fechaPedidoProveedor"),
    @NamedQuery(name = "DetallePedidoproveedor.findByFechaEntregaProveedor", query = "SELECT d FROM DetallePedidoproveedor d WHERE d.fechaEntregaProveedor = :fechaEntregaProveedor")})
public class DetallePedidoproveedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Detalle_PedidoProveedor")
    private Integer idDetallePedidoProveedor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Precio_ProductoUnidad")
    private long precioProductoUnidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cantidad")
    private int cantidad;
    @Column(name = "Descuento")
    private Integer descuento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Entregado")
    private boolean entregado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha_PedidoProveedor")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPedidoProveedor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha_EntregaProveedor")
    @Temporal(TemporalType.DATE)
    private Date fechaEntregaProveedor;
    @JoinColumn(name = "Id_Proveedor", referencedColumnName = "Id_Proveedor")
    @ManyToOne(optional = false)
    private Proveedor proveedor;
    @JoinColumn(name = "Id_Producto", referencedColumnName = "Id_Producto")
    @ManyToOne(optional = false)
    private Producto producto;

    public DetallePedidoproveedor() {
    }

    public DetallePedidoproveedor(Integer idDetallePedidoProveedor) {
        this.idDetallePedidoProveedor = idDetallePedidoProveedor;
    }

    public DetallePedidoproveedor(Integer idDetallePedidoProveedor, long precioProductoUnidad, int cantidad, boolean entregado, Date fechaPedidoProveedor, Date fechaEntregaProveedor) {
        this.idDetallePedidoProveedor = idDetallePedidoProveedor;
        this.precioProductoUnidad = precioProductoUnidad;
        this.cantidad = cantidad;
        this.entregado = entregado;
        this.fechaPedidoProveedor = fechaPedidoProveedor;
        this.fechaEntregaProveedor = fechaEntregaProveedor;
    }

    public Integer getIdDetallePedidoProveedor() {
        return idDetallePedidoProveedor;
    }

    public void setIdDetallePedidoProveedor(Integer idDetallePedidoProveedor) {
        this.idDetallePedidoProveedor = idDetallePedidoProveedor;
    }

    public long getPrecioProductoUnidad() {
        return precioProductoUnidad;
    }

    public void setPrecioProductoUnidad(long precioProductoUnidad) {
        this.precioProductoUnidad = precioProductoUnidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getDescuento() {
        return descuento;
    }

    public void setDescuento(Integer descuento) {
        this.descuento = descuento;
    }

    public boolean getEntregado() {
        return entregado;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }

    public Date getFechaPedidoProveedor() {
        return fechaPedidoProveedor;
    }

    public void setFechaPedidoProveedor(Date fechaPedidoProveedor) {
        this.fechaPedidoProveedor = fechaPedidoProveedor;
    }

    public Date getFechaEntregaProveedor() {
        return fechaEntregaProveedor;
    }

    public void setFechaEntregaProveedor(Date fechaEntregaProveedor) {
        this.fechaEntregaProveedor = fechaEntregaProveedor;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetallePedidoProveedor != null ? idDetallePedidoProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallePedidoproveedor)) {
            return false;
        }
        DetallePedidoproveedor other = (DetallePedidoproveedor) object;
        if ((this.idDetallePedidoProveedor == null && other.idDetallePedidoProveedor != null) || (this.idDetallePedidoProveedor != null && !this.idDetallePedidoProveedor.equals(other.idDetallePedidoProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.entity.DetallePedidoproveedor[ idDetallePedidoProveedor=" + idDetallePedidoProveedor + " ]";
    }
    
}
