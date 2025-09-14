package mx.com.mxds.gstinv.test;

import java.util.ArrayList;
import java.util.List;

import mx.com.mxds.gstinv.core.IGestorInventarios;
import mx.com.mxds.gstinv.dto.ArticuloInvDTO;
import mx.com.mxds.gstinv.entidades.ArticuloVtaStock;
import mx.com.mxds.gstinv.servicio.GestorInventario;

public class TestInventarios {

	public static void main(String[] args) {
		ejecutarPrueba();
	}

	private static void ejecutarPrueba() {
		IGestorInventarios gstInv = new GestorInventario();
		
		// Buscar un artículo del inventario
		ArticuloInvDTO artInvDto = gstInv.getArticuloInvXCodigo("MON-002");
		System.out.println("Articulo: " + artInvDto);
		
		// Buscar un artículo del inventario
		List<ArticuloInvDTO> articulosInv = gstInv.getInventario();
		System.out.println("Articulos: " + articulosInv);
		
		List<ArticuloVtaStock> articulosAct = new ArrayList<>();
		articulosAct.add(new ArticuloVtaStock(1L, 5));
		articulosAct.add(new ArticuloVtaStock(5L, 4));
		if(gstInv.actualizarStockVta(articulosAct)) System.out.println("Articulos actualizados");
		
		List<ArticuloInvDTO> articulosInvNvo = gstInv.getInventario();
		System.out.println("Articulos: " + articulosInvNvo);
		
	}

}
