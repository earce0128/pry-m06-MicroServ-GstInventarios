package mx.com.mxds.gstinv.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.json.bind.annotation.JsonbDateFormat;

public class OrdenVenta {
	
	private String idOrden;
	@JsonFormat(pattern = "yyyy-MM-dd")
	@JsonbDateFormat("yyyy-MM-dd")
	private LocalDate fechaVenta;
	private Long idVendedor;
	private String nombreVendedor;
	private String status;
	private BigDecimal subtotal;
	private double iva;
	private BigDecimal total;
	List<DetOrdenVta> detArticulos;
	
	public OrdenVenta() {}

	public String getIdOrden() {
		return idOrden;
	}

	public void setIdOrden(String idOrden) {
		this.idOrden = idOrden;
	}

	public LocalDate getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public Long getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(Long idVendedor) {
		this.idVendedor = idVendedor;
	}

	public String getNombreVendedor() {
		return nombreVendedor;
	}

	public void setNombreVendedor(String nombreVendedor) {
		this.nombreVendedor = nombreVendedor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public List<DetOrdenVta> getDetArticulos() {
		return detArticulos;
	}

	public void setDetArticulos(List<DetOrdenVta> detArticulos) {
		this.detArticulos = detArticulos;
	}

}
