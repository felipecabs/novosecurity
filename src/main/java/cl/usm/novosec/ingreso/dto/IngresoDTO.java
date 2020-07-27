package cl.usm.novosec.ingreso.dto;

import cl.usm.novosec.ingreso.model.Ingreso;

public class IngresoDTO {
	
	private UsuarioDTO usuarioDTO = new UsuarioDTO();
	
	public Ingreso castDaoToVo (cl.usm.novosec.ingreso.dao.Ingreso ingresoDAO) {
		Ingreso ingresoVO = new Ingreso();
		
		ingresoVO.setComentarios(ingresoDAO.getComentarios());
		ingresoVO.setEstacionamientoVisita(ingresoDAO.getEstacionamientoVisita());
		ingresoVO.setEstado(ingresoDAO.getEstado());
		ingresoVO.setFecha(ingresoDAO.getFecha());
		ingresoVO.setId(ingresoDAO.getId().getId());		
		ingresoVO.setTipo(ingresoDAO.getTipo());
		ingresoVO.setUsuario(usuarioDTO.castDaoToVo(ingresoDAO.getUsuario()));
		
		return ingresoVO;
	}
}
