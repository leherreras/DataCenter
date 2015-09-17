

package co.edu.sena.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;



@Entity
@Table(name = "producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findByIdProducto", query = "SELECT p FROM Producto p WHERE p.idProducto = :idProducto"),
    @NamedQuery(name = "Producto.findByNombreProducto", query = "SELECT p FROM Producto p WHERE p.nombreProducto = :nombreProducto"),
    @NamedQuery(name = "Producto.findByCostoVenta", query = "SELECT p FROM Producto p WHERE p.costoVenta = :costoVenta")})
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Producto")
    private Integer idProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Nombre_Producto")
    private String nombreProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Costo_Venta")
    private long costoVenta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private List<DetallePedidoproveedor> detallePedidoproveedorList;
    @JoinColumn(name = "Id_TipoProducto", referencedColumnName = "Id_TipoProducto")
    @ManyToOne(optional = false)
    private TipoProducto tipoProducto;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "producto")
    private Inventario inventario;

    public Producto() {
    }

    public Producto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Producto(Integer idProducto, String nombreProducto, long costoVenta) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.costoVenta = costoVenta;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public long getCostoVenta() {
        return costoVenta;
    }

    public void setCostoVenta(long costoVenta) {
        this.costoVenta = costoVenta;
    }

    @XmlTransient
    public List<DetallePedidoproveedor> getDetallePedidoproveedorList() {
        return detallePedidoproveedorList;
    }

    public void setDetallePedidoproveedorList(List<DetallePedidoproveedor> detallePedidoproveedorList) {
        this.detallePedidoproveedorList = detallePedidoproveedorList;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.entity.Producto[ idProducto=" + idProducto + " ]";
    }
    
}
