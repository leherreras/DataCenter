

package co.edu.sena.entity;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;



@Entity
@Table(name = "detalle_pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetallePedido.findAll", query = "SELECT d FROM DetallePedido d"),
    @NamedQuery(name = "DetallePedido.findByIdDetallePedido", query = "SELECT d FROM DetallePedido d WHERE d.idDetallePedido = :idDetallePedido"),
    @NamedQuery(name = "DetallePedido.findByCantidadPedido", query = "SELECT d FROM DetallePedido d WHERE d.cantidadPedido = :cantidadPedido"),
    @NamedQuery(name = "DetallePedido.findByEstadoPagoCliente", query = "SELECT d FROM DetallePedido d WHERE d.estadoPagoCliente = :estadoPagoCliente"),
    @NamedQuery(name = "DetallePedido.findByEstadoPagoColaborador", query = "SELECT d FROM DetallePedido d WHERE d.estadoPagoColaborador = :estadoPagoColaborador")})
public class DetallePedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_DetallePedido")
    private Integer idDetallePedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cantidad_Pedido")
    private int cantidadPedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Estado_PagoCliente")
    private boolean estadoPagoCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Estado_PagoColaborador")
    private boolean estadoPagoColaborador;
    @JoinColumn(name = "Id_Pedido", referencedColumnName = "Id_Pedido")
    @ManyToOne(optional = false)
    private Pedido pedido;
    @JoinColumn(name = "Id_Servicio", referencedColumnName = "Id_Servicio")
    @ManyToOne
    private Servicio servicio;
    @JoinColumn(name = "Id_Inventario", referencedColumnName = "Id_Inventario")
    @ManyToOne
    private Inventario inventario;
    @JoinColumn(name = "Id_TipoSalida", referencedColumnName = "Id_TipoSalida")
    @ManyToOne(optional = false)
    private TipoSalida tipoSalida;

    public DetallePedido() {
    }

    public DetallePedido(Integer idDetallePedido) {
        this.idDetallePedido = idDetallePedido;
    }

    public DetallePedido(Integer idDetallePedido, int cantidadPedido, boolean estadoPagoCliente, boolean estadoPagoColaborador) {
        this.idDetallePedido = idDetallePedido;
        this.cantidadPedido = cantidadPedido;
        this.estadoPagoCliente = estadoPagoCliente;
        this.estadoPagoColaborador = estadoPagoColaborador;
    }

    public Integer getIdDetallePedido() {
        return idDetallePedido;
    }

    public void setIdDetallePedido(Integer idDetallePedido) {
        this.idDetallePedido = idDetallePedido;
    }

    public int getCantidadPedido() {
        return cantidadPedido;
    }

    public void setCantidadPedido(int cantidadPedido) {
        this.cantidadPedido = cantidadPedido;
    }

    public boolean getEstadoPagoCliente() {
        return estadoPagoCliente;
    }

    public void setEstadoPagoCliente(boolean estadoPagoCliente) {
        this.estadoPagoCliente = estadoPagoCliente;
    }

    public boolean getEstadoPagoColaborador() {
        return estadoPagoColaborador;
    }

    public void setEstadoPagoColaborador(boolean estadoPagoColaborador) {
        this.estadoPagoColaborador = estadoPagoColaborador;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public TipoSalida getTipoSalida() {
        return tipoSalida;
    }

    public void setTipoSalida(TipoSalida tipoSalida) {
        this.tipoSalida = tipoSalida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetallePedido != null ? idDetallePedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallePedido)) {
            return false;
        }
        DetallePedido other = (DetallePedido) object;
        if ((this.idDetallePedido == null && other.idDetallePedido != null) || (this.idDetallePedido != null && !this.idDetallePedido.equals(other.idDetallePedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.entity.DetallePedido[ idDetallePedido=" + idDetallePedido + " ]";
    }
    
}
