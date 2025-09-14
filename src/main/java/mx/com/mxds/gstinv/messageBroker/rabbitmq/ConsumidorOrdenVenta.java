package mx.com.mxds.gstinv.messageBroker.rabbitmq;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import mx.com.mxds.gstinv.core.IConsumidorMsgOrdVentaNueva;
import mx.com.mxds.gstinv.core.IGestorInventarios;
import mx.com.mxds.gstinv.entidades.ArticuloVtaStock;
import mx.com.mxds.gstinv.entidades.DetOrdenVta;
import mx.com.mxds.gstinv.entidades.OrdenVenta;

public class ConsumidorOrdenVenta extends ConsumidorMensajes implements IConsumidorMsgOrdVentaNueva {
	
	private static Logger bitacora = LoggerFactory.getLogger(ConsumidorOrdenVenta.class);
	private IGestorInventarios gstInventario;
	
	public ConsumidorOrdenVenta(String host, String nomCola, String nomExchange, IGestorInventarios gstInventario) {
		super(host, nomCola, nomExchange);
		this.gstInventario = gstInventario;
		
		bitacora.info("ConsumidorEventoNuevo(" + host + ", " + nomCola + ", " + nomExchange + ") instanciado");
	}
	
	@Override
	public void procesarMensajeJson(String mensaje) {
		Jsonb jsonb = JsonbBuilder.create();
		OrdenVenta venta = jsonb.fromJson(mensaje, OrdenVenta.class);
		bitacora.info("InvMsg: " + venta.getDetArticulos());
		List<ArticuloVtaStock> artVtaStock = new ArrayList<>();
		for(DetOrdenVta ordVta : venta.getDetArticulos()) {
			ArticuloVtaStock artVtaStoc = new ArticuloVtaStock(ordVta.getIdArticulo(), ordVta.getCantidad());
			artVtaStock.add(artVtaStoc);
		}
		bitacora.info("InvMsg Inventario anterior: " + this.gstInventario.getInventario());
		if(this.gstInventario.actualizarStockVta(artVtaStock)) {
			bitacora.info("InvMsg Inventario actualizado: " + artVtaStock);
			bitacora.info("InvMsg Inventario actual: " + this.gstInventario.getInventario());
		} else { bitacora.error("Inventario no actualizado:" + artVtaStock);}
		
	}
	
	@Override
	public void consumirMensajes() {
		super.consumirMensajes();
		bitacora.info("Recuperación de mensajes en segundo plano activa. Id(Consumer tag)=" + this.idConsumidor);		
	}
}
