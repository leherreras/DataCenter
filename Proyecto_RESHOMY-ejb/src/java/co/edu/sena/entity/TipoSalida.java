

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;



@Entity
@Table(name = "tipo_salida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoSalida.findAll", query = "SELECT t FROM TipoSalida t"),
    @NamedQuery(name = "TipoSalida.findByIdTipoSalida", query = "SELECT t FROM TipoSalida t WHERE t.idTipoSalida = :idTipoSalida"),
    @NamedQuery(name = "TipoSalida.findByDestino", query = "SELECT t FROM TipoSalida t WHERE t.destino = :destino")})
public class TipoSalida implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_TipoSalida")
    private Integer idTipoSalida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Destino")
    private boolean destino;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoSalida")
    private List<DetallePedido> detallePedidoList;

    public TipoSalida() {
    }

    public TipoSalida(Integer idTipoSalida) {
        this.idTipoSalida = idTipoSalida;
    }

    public TipoSalida(Integer idTipoSalida, boolean destino) {
        this.idTipoSalida = idTipoSalida;
        this.destino = destino;
    }

    public Integer getIdTipoSalida() {
        return idTipoSalida;
    }

    public void setIdTipoSalida(Integer idTipoSalida) {
        this.idTipoSalida = idTipoSalida;
    }

    public boolean getDestino() {
        return destino;
    }

    public void setDestino(boolean destino) {
        this.destino = destino;
    }

    @XmlTransient
    public List<DetallePedido> getDetallePedidoList() {
        return detallePedidoList;
    }

    public void setDetallePedidoList(List<DetallePedido> detallePedidoList) {
        this.detallePedidoList = detallePedidoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoSalida != null ? idTipoSalida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoSalida)) {
            return false;
        }
        TipoSalida other = (TipoSalida) object;
        if ((this.idTipoSalida == null && other.idTipoSalida != null) || (this.idTipoSalida != null && !this.idTipoSalida.equals(other.idTipoSalida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.entity.TipoSalida[ idTipoSalida=" + idTipoSalida + " ]";
    }
    
}
