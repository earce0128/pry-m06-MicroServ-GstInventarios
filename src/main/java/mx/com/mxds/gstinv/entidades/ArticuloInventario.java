package mx.com.mxds.gstinv.entidades;

import java.math.BigDecimal;
import java.util.Objects;

public class ArticuloInventario {
	
	private Long idArticulo;
	private String codigo;
	private String descripcion;
	private BigDecimal precioBase;
	private BigDecimal costo;
	private int stock;
	private int stock_min;
	private int stock_max;
	
	public ArticuloInventario() {
		super();
	}

	public ArticuloInventario(Long idArticulo, String codigo, String descripcion, BigDecimal precioBase,
			BigDecimal costo, int stock, int stock_min, int stock_max) {
		super();
		this.idArticulo = idArticulo;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioBase = precioBase;
		this.costo = costo;
		this.stock = stock;
		this.stock_min = stock_min;
		this.stock_max = stock_max;
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

	public BigDecimal getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(BigDecimal precioBase) {
		this.precioBase = precioBase;
	}

	public BigDecimal getCosto() {
		return costo;
	}

	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getStock_min() {
		return stock_min;
	}

	public void setStock_min(int stock_min) {
		this.stock_min = stock_min;
	}

	public int getStock_max() {
		return stock_max;
	}

	public void setStock_max(int stock_max) {
		this.stock_max = stock_max;
	}

	@Override
	public String toString() {
		return "ArticuloInventario [idArticulo=" + idArticulo + ", codigo=" + codigo + ", descripcion=" + descripcion
				+ ", precioBase=" + precioBase + ", costo=" + costo + ", stock=" + stock + ", stock_min=" + stock_min
				+ ", stock_max=" + stock_max + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, costo, descripcion, idArticulo, precioBase, stock, stock_max, stock_min);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArticuloInventario other = (ArticuloInventario) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(costo, other.costo)
				&& Objects.equals(descripcion, other.descripcion) && Objects.equals(idArticulo, other.idArticulo)
				&& Objects.equals(precioBase, other.precioBase) && stock == other.stock && stock_max == other.stock_max
				&& stock_min == other.stock_min;
	}
	
}
