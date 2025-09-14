package mx.com.mxds.gstinv.entidades;

import java.util.Objects;

public class ArticuloVtaStock {
	
	private Long idArticulo;
	private int stock_vta;
	
	public ArticuloVtaStock() {}

	public ArticuloVtaStock(Long idArticulo, int stock_vta) {
		super();
		this.idArticulo = idArticulo;
		this.stock_vta = stock_vta;
	}

	public Long getIdArticulo() {
		return idArticulo;
	}

	public void setIdArticulo(Long idArticulo) {
		this.idArticulo = idArticulo;
	}

	public int getStock_vta() {
		return stock_vta;
	}

	public void setStock_vta(int stock_vta) {
		this.stock_vta = stock_vta;
	}

	@Override
	public String toString() {
		return "ArticuloVtasStock [idArticulo=" + idArticulo + ", stock_vta=" + stock_vta + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idArticulo, stock_vta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArticuloVtaStock other = (ArticuloVtaStock) obj;
		return Objects.equals(idArticulo, other.idArticulo) && stock_vta == other.stock_vta;
	}

}
