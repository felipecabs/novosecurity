package cl.usm.novosec.ingreso.dto;

import cl.usm.novosec.ingreso.model.Invitacion;

public class InvitacionDTO {
	
	private UsuarioDTO usuarioDTO = new UsuarioDTO();
	
	public Invitacion castDaoToVo (cl.usm.novosec.ingreso.dao.Invitacion invitacionDAO) {
		Invitacion invitacionVO = new Invitacion();
		// Coomposicion de la invitacion de salida
		
		invitacionVO.setEstado(invitacionDAO.getEstado());
		invitacionVO.setFecha(invitacionDAO.getFecha());
		invitacionVO.setId(invitacionDAO.getId());
		
		// -> Composicion del usuario de destino
		invitacionVO.setUsuarioDestino(usuarioDTO.castDaoToVo(invitacionDAO.getUsuario1()));
		
		// -> Composicion del usuario de origen
		invitacionVO.setUsuarioOrigen(usuarioDTO.castDaoToVo(invitacionDAO.getUsuario2()));
		
		return invitacionVO;
		
	}
	
}
