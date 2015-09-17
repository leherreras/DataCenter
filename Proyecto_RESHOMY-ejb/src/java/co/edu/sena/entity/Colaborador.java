

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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;



@Entity
@Table(name = "colaborador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Colaborador.findAll", query = "SELECT c FROM Colaborador c"),
    @NamedQuery(name = "Colaborador.findByAutenticar", query = "SELECT c FROM Colaborador c WHERE c.nombreUsuario = :nombreUsuario AND c.contrasena = :contrasena"),
    @NamedQuery(name = "Colaborador.findByIdColaborador", query = "SELECT c FROM Colaborador c WHERE c.idColaborador = :idColaborador"),
    @NamedQuery(name = "Colaborador.findByNombreUsuario", query = "SELECT c FROM Colaborador c WHERE c.nombreUsuario = :nombreUsuario"),
    @NamedQuery(name = "Colaborador.findByContrasena", query = "SELECT c FROM Colaborador c WHERE c.contrasena = :contrasena"),
    @NamedQuery(name = "Colaborador.findByNombresColaborador", query = "SELECT c FROM Colaborador c WHERE c.nombresColaborador = :nombresColaborador"),
    @NamedQuery(name = "Colaborador.findByPrimerApellido", query = "SELECT c FROM Colaborador c WHERE c.primerApellido = :primerApellido"),
    @NamedQuery(name = "Colaborador.findBySegundoApellido", query = "SELECT c FROM Colaborador c WHERE c.segundoApellido = :segundoApellido"),
    @NamedQuery(name = "Colaborador.findBySexo", query = "SELECT c FROM Colaborador c WHERE c.sexo = :sexo"),
    @NamedQuery(name = "Colaborador.findByEspecialidad", query = "SELECT c FROM Colaborador c WHERE c.especialidad = :especialidad"),
    @NamedQuery(name = "Colaborador.findByIdentificacion", query = "SELECT c FROM Colaborador c WHERE c.identificacion = :identificacion"),
    @NamedQuery(name = "Colaborador.findByTelefono", query = "SELECT c FROM Colaborador c WHERE c.telefono = :telefono"),
    @NamedQuery(name = "Colaborador.findByDireccion", query = "SELECT c FROM Colaborador c WHERE c.direccion = :direccion")})
public class Colaborador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Colaborador")
    private Integer idColaborador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Nombre_Usuario")
    private String nombreUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Contrasena")
    private String contrasena;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "Nombres_Colaborador")
    private String nombresColaborador;
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
    @Column(name = "Sexo")
    private boolean sexo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Especialidad")
    private String especialidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Identificacion")
    private long identificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Telefono")
    private long telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Direccion")
    private String direccion;
    @JoinColumn(name = "Id_Rol", referencedColumnName = "Id_Rol")
    @ManyToOne(optional = false)
    private Rol rol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "colaborador")
    private List<Pedido> pedidoList;

    public Colaborador() {
    }

    public Colaborador(Integer idColaborador) {
        this.idColaborador = idColaborador;
    }

    public Colaborador(Integer idColaborador, String nombreUsuario, String contrasena, String nombresColaborador, String primerApellido, String segundoApellido, boolean sexo, String especialidad, long identificacion, long telefono, String direccion) {
        this.idColaborador = idColaborador;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.nombresColaborador = nombresColaborador;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.sexo = sexo;
        this.especialidad = especialidad;
        this.identificacion = identificacion;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Integer getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(Integer idColaborador) {
        this.idColaborador = idColaborador;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombresColaborador() {
        return nombresColaborador;
    }

    public void setNombresColaborador(String nombresColaborador) {
        this.nombresColaborador = nombresColaborador;
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

    public boolean getSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public long getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(long identificacion) {
        this.identificacion = identificacion;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @XmlTransient
    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idColaborador != null ? idColaborador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Colaborador)) {
            return false;
        }
        Colaborador other = (Colaborador) object;
        if ((this.idColaborador == null && other.idColaborador != null) || (this.idColaborador != null && !this.idColaborador.equals(other.idColaborador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.entity.Colaborador[ idColaborador=" + idColaborador + " ]";
    }
    
}
