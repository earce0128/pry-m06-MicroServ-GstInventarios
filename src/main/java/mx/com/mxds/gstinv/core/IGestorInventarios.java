package mx.com.mxds.gstinv.core;

import java.util.List;

import mx.com.mxds.gstinv.dto.ArticuloInvDTO;
import mx.com.mxds.gstinv.entidades.ArticuloVtaStock;

public interface IGestorInventarios {
	
	List<ArticuloInvDTO> getInventario();
	
	ArticuloInvDTO getArticuloInvXCodigo(String codigo);
	
	boolean actualizarStockVta(List<ArticuloVtaStock> artVtas);

}
