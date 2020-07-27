package cl.usm.novosec.ingreso.dto;

import java.sql.Date;

import cl.usm.novosec.ingreso.model.Usuario;

public class UsuarioDTO {
	public Usuario castDaoToVo(cl.usm.novosec.ingreso.dao.Usuario usuarioDAO) {
		Usuario usuarioVO = new Usuario();
		
		usuarioVO.setDepartamento(usuarioDAO.getDepartamento());
		usuarioVO.setFechaNacimiento((Date) usuarioDAO.getFechaNacimiento());
		usuarioVO.setGenero(usuarioDAO.getGenero());
		usuarioVO.setMail(usuarioDAO.getMail());
		usuarioVO.setNombre(usuarioDAO.getNombre());
		usuarioVO.setRut(usuarioDAO.getRut());
		usuarioVO.setTelefono(usuarioDAO.getTelefono());
		
		return usuarioVO;
	}
}
