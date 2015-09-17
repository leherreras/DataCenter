

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;



@Entity
@Table(name = "proveedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedor.findAll", query = "SELECT p FROM Proveedor p"),
    @NamedQuery(name = "Proveedor.findByIdProveedor", query = "SELECT p FROM Proveedor p WHERE p.idProveedor = :idProveedor"),
    @NamedQuery(name = "Proveedor.findByNitProveedor", query = "SELECT p FROM Proveedor p WHERE p.nitProveedor = :nitProveedor"),
    @NamedQuery(name = "Proveedor.findByNombresProveedor", query = "SELECT p FROM Proveedor p WHERE p.nombresProveedor = :nombresProveedor"),
    @NamedQuery(name = "Proveedor.findByPrimerApellido", query = "SELECT p FROM Proveedor p WHERE p.primerApellido = :primerApellido"),
    @NamedQuery(name = "Proveedor.findBySegundoApellido", query = "SELECT p FROM Proveedor p WHERE p.segundoApellido = :segundoApellido"),
    @NamedQuery(name = "Proveedor.findByNombreCompania", query = "SELECT p FROM Proveedor p WHERE p.nombreCompania = :nombreCompania"),
    @NamedQuery(name = "Proveedor.findByCargoContacto", query = "SELECT p FROM Proveedor p WHERE p.cargoContacto = :cargoContacto"),
    @NamedQuery(name = "Proveedor.findByDireccion", query = "SELECT p FROM Proveedor p WHERE p.direccion = :direccion"),
    @NamedQuery(name = "Proveedor.findByPais", query = "SELECT p FROM Proveedor p WHERE p.pais = :pais"),
    @NamedQuery(name = "Proveedor.findByCiudad", query = "SELECT p FROM Proveedor p WHERE p.ciudad = :ciudad"),
    @NamedQuery(name = "Proveedor.findByPaginaOficial", query = "SELECT p FROM Proveedor p WHERE p.paginaOficial = :paginaOficial"),
    @NamedQuery(name = "Proveedor.findByTelefono", query = "SELECT p FROM Proveedor p WHERE p.telefono = :telefono"),
    @NamedQuery(name = "Proveedor.findByExtension", query = "SELECT p FROM Proveedor p WHERE p.extension = :extension")})
public class Proveedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Proveedor")
    private Integer idProveedor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Nit_Proveedor")
    private int nitProveedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "Nombres_Proveedor")
    private String nombresProveedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "Primer_Apellido")
    private String primerApellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "Segundo_Apellido")
    private String segundoApellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Nombre_Compania")
    private String nombreCompania;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Cargo_Contacto")
    private String cargoContacto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Pais")
    private String pais;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "Ciudad")
    private String ciudad;
    @Size(max = 45)
    @Column(name = "Pagina_Oficial")
    private String paginaOficial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Telefono")
    private long telefono;
    @Column(name = "Extension")
    private Integer extension;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proveedor")
    private List<DetallePedidoproveedor> detallePedidoproveedorList;

    public Proveedor() {
    }

    public Proveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Proveedor(Integer idProveedor, int nitProveedor, String nombresProveedor, String primerApellido, String segundoApellido, String nombreCompania, String cargoContacto, String direccion, String pais, String ciudad, long telefono) {
        this.idProveedor = idProveedor;
        this.nitProveedor = nitProveedor;
        this.nombresProveedor = nombresProveedor;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.nombreCompania = nombreCompania;
        this.cargoContacto = cargoContacto;
        this.direccion = direccion;
        this.pais = pais;
        this.ciudad = ciudad;
        this.telefono = telefono;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public int getNitProveedor() {
        return nitProveedor;
    }

    public void setNitProveedor(int nitProveedor) {
        this.nitProveedor = nitProveedor;
    }

    public String getNombresProveedor() {
        return nombresProveedor;
    }

    public void setNombresProveedor(String nombresProveedor) {
        this.nombresProveedor = nombresProveedor;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getNombreCompania() {
        return nombreCompania;
    }

    public void setNombreCompania(String nombreCompania) {
        this.nombreCompania = nombreCompania;
    }

    public String getCargoContacto() {
        return cargoContacto;
    }

    public void setCargoContacto(String cargoContacto) {
        this.cargoContacto = cargoContacto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPaginaOficial() {
        return paginaOficial;
    }

    public void setPaginaOficial(String paginaOficial) {
        this.paginaOficial = paginaOficial;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public Integer getExtension() {
        return extension;
    }

    public void setExtension(Integer extension) {
        this.extension = extension;
    }

    @XmlTransient
    public List<DetallePedidoproveedor> getDetallePedidoproveedorList() {
        return detallePedidoproveedorList;
    }

    public void setDetallePedidoproveedorList(List<DetallePedidoproveedor> detallePedidoproveedorList) {
        this.detallePedidoproveedorList = detallePedidoproveedorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProveedor != null ? idProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.idProveedor == null && other.idProveedor != null) || (this.idProveedor != null && !this.idProveedor.equals(other.idProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.entity.Proveedor[ idProveedor=" + idProveedor + " ]";
    }
    
}
