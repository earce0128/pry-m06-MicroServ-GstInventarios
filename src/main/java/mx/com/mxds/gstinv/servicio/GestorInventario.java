package mx.com.mxds.gstinv.servicio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import mx.com.mxds.gstinv.core.IGestorInventarios;
import mx.com.mxds.gstinv.dto.ArticuloInvDTO;
import mx.com.mxds.gstinv.entidades.ArticuloInventario;
import mx.com.mxds.gstinv.entidades.ArticuloVtaStock;

@Service
public class GestorInventario implements IGestorInventarios {
	
	private static Map<String, Long> codigoToId = new ConcurrentHashMap<>();
	private static Map<Long,ArticuloInventario> mapArtInventario = crearInventario();
	
	@Override
	public List<ArticuloInvDTO> getInventario() {
		
		List<ArticuloInvDTO> articulosVtas = new ArrayList<>();
		
		for (Map.Entry<Long, ArticuloInventario> artInv : mapArtInventario.entrySet()) {
			ArticuloInvDTO artDto = new ArticuloInvDTO();
        	artDto.setIdArticulo(artInv.getValue().getIdArticulo());
        	artDto.setCodigo(artInv.getValue().getCodigo());
        	artDto.setDescripcion(artInv.getValue().getDescripcion());
        	artDto.setPrecioBase(artInv.getValue().getPrecioBase());
        	artDto.setStock(artInv.getValue().getStock());
        	articulosVtas.add(artDto);
		}
		
		return articulosVtas;
	}

	@Override
	public ArticuloInvDTO getArticuloInvXCodigo(String codigo) {
		Long id = codigoToId.get(codigo);
		
        if (id != null) {
        	ArticuloInvDTO artDto = new ArticuloInvDTO();
        	ArticuloInventario artInv = mapArtInventario.get(id);
        	artDto.setIdArticulo(artInv.getIdArticulo());
        	artDto.setCodigo(artInv.getCodigo());
        	artDto.setDescripcion(artInv.getDescripcion());
        	artDto.setPrecioBase(artInv.getPrecioBase());
        	artDto.setStock(artInv.getStock());
        	return artDto;
        }
        return null;
	}

	@Override
	public boolean actualizarStockVta(List<ArticuloVtaStock> artVtas) {
		
		for(ArticuloVtaStock artVta : artVtas) {
			ArticuloInventario artInv = mapArtInventario.get(artVta.getIdArticulo());
			int stockInv = artInv.getStock();
			int stockVta = artVta.getStock_vta();
			artInv.setStock(stockInv - stockVta);
		}
		return true;
	}
	
	private static Map<Long, ArticuloInventario> crearInventario() {
		Map<Long,ArticuloInventario> mArtInv = new HashMap<>();
		
		mArtInv.put(1L,new ArticuloInventario(1L,"LAP-001", "Laptop Dell XPS 13", new BigDecimal("18999.00"), 
											new BigDecimal("17500.00"), 15, 3, 25));
		codigoToId.put("LAP-001",1L);
		mArtInv.put(2L,new ArticuloInventario(2L,"MON-002", "Monitor Samsung 24\" Curvo", new BigDecimal("3499.00"), 
											new BigDecimal("2000.00"), 25, 5, 30));
		codigoToId.put("MON-002",2L);
		mArtInv.put(3L,new ArticuloInventario(3L,"TEC-003", "Teclado Mecánico Redragon Kumara", new BigDecimal("899.00"),
											new BigDecimal("500.00"),40, 10, 50));
		codigoToId.put("TEC-003",3L);
		mArtInv.put(4L,new ArticuloInventario(4L,"MOU-004", "Mouse Logitech G203 Lightsync", new BigDecimal("499.00"),
											new BigDecimal("300.00"), 60, 20, 90));
		codigoToId.put("MOU-004",4L);
		mArtInv.put(5L,new ArticuloInventario(5L,"AUD-005", "Audífonos Sony WH-CH510", new BigDecimal("1299.00"),
											new BigDecimal("1000.00"),30, 10, 150));
		codigoToId.put("AUD-005",5L);
		mArtInv.put(6L,new ArticuloInventario(6L,"TAB-006", "Tableta Samsung Galaxy Tab A8", new BigDecimal("5499.00"), 
											new BigDecimal("4500.00"), 18, 5, 40));
		codigoToId.put("TAB-006",6L);
		mArtInv.put(7L,new ArticuloInventario(7L,"IMP-007", "Impresora HP Deskjet 2775", new BigDecimal("1999.00"), 
											new BigDecimal("1000.00"), 12, 5, 20));
		codigoToId.put("IMP-007",7L);
		mArtInv.put(8L,new ArticuloInventario(8L,"DIS-008", "Disco Duro Externo Seagate 1TB", new BigDecimal("1299.00"), 
											new BigDecimal("900.00"), 22, 10, 40));
		codigoToId.put("DIS-008",8L);
		mArtInv.put(9L,new ArticuloInventario(9L,"MEM-009", "Memoria USB Kingston 64GB", new BigDecimal("299.00"), 
											new BigDecimal("100.00"), 100, 50, 200));
		codigoToId.put("MEM-009",9L);
		mArtInv.put(10L,new ArticuloInventario(10L,"CAM-010", "Cámara Web Logitech C920", new BigDecimal("1799.00"), 
											new BigDecimal("1600.00"), 20, 10, 50));
		codigoToId.put("CAM-010",10L);
		
		return mArtInv;
	}

	

}
