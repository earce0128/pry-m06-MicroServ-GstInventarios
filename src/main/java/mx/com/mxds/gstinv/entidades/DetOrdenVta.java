package mx.com.mxds.gstinv.entidades;

import java.math.BigDecimal;
import java.util.Objects;

public class DetOrdenVta {
	
	private String idOrden;
	private Long idArticulo;
	private String codigo;
	private String descripcion;
	private int cantidad;
	private BigDecimal precioBase;
	
	public DetOrdenVta() {}

	public DetOrdenVta(String idOrden, Long idArticulo, String codigo, String descripcion, int cantidad, BigDecimal precioBase) {
		super();
		this.idOrden = idOrden;
		this.idArticulo = idArticulo;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.precioBase = precioBase;
	}

	public String getIdOrden() {
		return idOrden;
	}

	public void setIdOrden(String idOrden) {
		this.idOrden = idOrden;
	}

	public Long getIdArticulo() {
		return idArticulo;
	}

	public void setIdArticulo(Long idArticulo) {
		this.idArticulo = idArticulo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(BigDecimal precioBase) {
		this.precioBase = precioBase;
	}

	@Override
	public String toString() {
		return "DetOrdenVta [idOrden=" + idOrden + ", idArticulo=" + idArticulo + ", codigo=" + codigo
				+ ", descripcion=" + descripcion + ", cantidad=" + cantidad + ", precioBase=" + precioBase + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cantidad, codigo, descripcion, idArticulo, idOrden, precioBase);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetOrdenVta other = (DetOrdenVta) obj;
		return cantidad == other.cantidad && Objects.equals(codigo, other.codigo)
				&& Objects.equals(descripcion, other.descripcion) && Objects.equals(idArticulo, other.idArticulo)
				&& Objects.equals(idOrden, other.idOrden) && Objects.equals(precioBase, other.precioBase);
	}

}
