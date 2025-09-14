package mx.com.mxds.gstinv.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import mx.com.mxds.gstinv.core.IGestorInventarios;
import mx.com.mxds.gstinv.dto.ArticuloInvDTO;
import mx.com.mxds.gstinv.entidades.ArticuloVtaStock;


@RestController
public class ApiController {
	
	private static Logger bitacora = LoggerFactory.getLogger(ApiController.class);

	@Autowired
	private IGestorInventarios gstInv;
	
	@GetMapping(path = "/inventario", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ArticuloInvDTO> getInventario() {
		return this.gstInv.getInventario();
	}
	
	@GetMapping(path = "/inventario/{codigo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ArticuloInvDTO getArtInvXCodigo(@PathVariable String codigo) {
		return this.gstInv.getArticuloInvXCodigo(codigo);
	}
	
	@PutMapping(path="/inventario/" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean actualizarStock (@RequestBody List<ArticuloVtaStock> articulos) {
		bitacora.debug("Inv = [" + articulos + "]");
		bitacora.debug("Inv = [" + gstInv.getInventario() + "]");
		if(this.gstInv.actualizarStockVta(articulos)) {
			bitacora.debug("Inv = [" + articulos + "]");
			bitacora.debug("Inv = [" + gstInv.getInventario() + "]");
			return true;
		} else {
			return false;
		}
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorFormato> manejarErrores(
			MethodArgumentTypeMismatchException matmex){
		ErrorFormato err = ErrorFormato.crearErrorFormatoURI("Invocación con argumentos erróneos", 
				                                              matmex.getMessage());
		return new ResponseEntity<ErrorFormato>(err,HttpStatus.NOT_ACCEPTABLE);
		
	}
}
