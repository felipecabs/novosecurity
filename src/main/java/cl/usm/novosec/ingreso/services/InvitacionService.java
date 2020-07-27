package cl.usm.novosec.ingreso.services;

import java.util.Iterator;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.usm.novosec.ingreso.dao.Invitacion;
import cl.usm.novosec.ingreso.dao.Usuario;
import cl.usm.novosec.ingreso.dto.InvitacionDTO;
import cl.usm.novosec.ingreso.repository.InvitacionRepository;
import cl.usm.novosec.ingreso.repository.UsuarioRepository;
import cl.usm.novosec.ingreso.signature.CommonResponse;
import cl.usm.novosec.ingreso.signature.CompartirInvitacionReq;
import cl.usm.novosec.ingreso.signature.CompartirInvitacionRes;
import cl.usm.novosec.ingreso.signature.CrearInvitacionReq;
import cl.usm.novosec.ingreso.signature.EditarInvitacionReq;
import cl.usm.novosec.ingreso.signature.EliminarInvitacionReq;
import cl.usm.novosec.ingreso.signature.ListarInvitadosReq;
import cl.usm.novosec.ingreso.signature.ListarInvitadosRes;

@Service
public class InvitacionService {
	
	final static String MSG_ERR_1_DUPLICIDAD = "No puede crear una invitación a sí mismo";
	final static String MSG_ERR_2_NOEXISTE = "El registro a editar no existe";
	final static String MSG_ERR_TECNICO = "No se pudo crear una invitacion, contacte al administrador del sistema";
	final static String MSG_SUCC= "El registro fue creado exitosamente";
	
	Logger logger = LoggerFactory.getLogger(InvitacionService.class);
	
	@Autowired
	InvitacionRepository invitacionRepo;
	
	@Autowired
	UsuarioRepository usuarioRepo;
	
	public ListarInvitadosRes listarInvitados(ListarInvitadosReq listarInvitados) {
		ListarInvitadosRes listarInvitadosRes = new ListarInvitadosRes();
		
		Iterable<Invitacion> lstInvitados = invitacionRepo.findAll();
		Iterator<Invitacion> it = lstInvitados.iterator();
		
		Invitacion invitacionDAO;
		InvitacionDTO invitacionDTO = new InvitacionDTO();
		
		while(it.hasNext()) {
			
			invitacionDAO = null;
			invitacionDAO = it.next();
			
			logger.debug(String.format("id consultado -> %d", invitacionDAO.getId()));
			listarInvitadosRes.getInvitaciones().add(invitacionDTO.castDaoToVo(invitacionDAO));
		}
		
		return listarInvitadosRes;
	}
	
	public CommonResponse crearInvitacion(CrearInvitacionReq crearInvitacion) {
		
		CommonResponse commResponse = new CommonResponse();
		Invitacion invitacion = new Invitacion();
		Usuario usuario = null;
		boolean error = false;
		
		invitacion.setEstado(crearInvitacion.getEstado());
		invitacion.setFecha((crearInvitacion.getFecha()!= null)?crearInvitacion.getFecha():null);
		
		logger.info("Buscar al usuario de origen");
		// Buscar los usuarios relacionados a la invitacion (Origen)
		usuario = usuarioRepo.findById(crearInvitacion.getRutOrigen()).get();
		invitacion.setUsuario2(usuario);
		
		logger.info("Buscar al usuario de destino");
		// Buscar los usuarios relacionados a la invitacion (Destino)
		usuario = usuarioRepo.findById(crearInvitacion.getRutDestino()).get();
		invitacion.setUsuario1(usuario);
		
		// Validaciones
		// Que sea una invitacion a si mismo
		if(invitacion.getUsuario1().equals(invitacion.getUsuario2())) {
			commResponse.setMessage(MSG_ERR_1_DUPLICIDAD);
			commResponse.setErrorCode(1);
			commResponse.setSuccess(false);
			error = true;
		}
		
		// Que ambos usuarios existan
		if(invitacion.getUsuario1() == null || invitacion.getUsuario2() == null){
			commResponse.setMessage(MSG_ERR_1_DUPLICIDAD);
			commResponse.setErrorCode(1);
			commResponse.setSuccess(false);
			error = true;
		}
		
		// Ejecucion de la creación del registro
		if(!error) {
			if(invitacionRepo.save(invitacion) instanceof Invitacion) {
				commResponse.setMessage(MSG_SUCC);
				commResponse.setErrorCode(0);
				commResponse.setSuccess(true);
			}
			else {
				logger.debug("Hubo un error tecnico en la consulta que escribe la invitacion");
				commResponse.setMessage(MSG_ERR_TECNICO);
				commResponse.setErrorCode(2);
				commResponse.setSuccess(false);
			}
		}
		
		return commResponse;
	}
	
	public CommonResponse editarInvitacion(EditarInvitacionReq editarInvitacion) {
		CommonResponse commonResponse = new CommonResponse();
		
		logger.debug(String.format("id a editar [%d]", editarInvitacion.getId()));
		
		Optional<Invitacion> invitacionOriginal = invitacionRepo.findById(editarInvitacion.getId());
		
		// Fue encontrado el registro de invitacion?
		if(invitacionOriginal.isPresent()) {
			
			// Se elimina el registro antiguo
			invitacionRepo.deleteById(invitacionOriginal.get().getId());
			
			// Composicion de registro nuevo con datos a modificar.
			CrearInvitacionReq crearInvitacion = new CrearInvitacionReq();
			crearInvitacion.setEstado(editarInvitacion.getEstado());
			crearInvitacion.setRutOrigen(editarInvitacion.getRutOrigen());
			crearInvitacion.setRutDestino(editarInvitacion.getRutDestino());
			
			// Se invoca al servicio de creacion para pasar por las validaciones.
			commonResponse = this.crearInvitacion(crearInvitacion);
			
			// Si ocurrió algun problema con la creación.
			if(!commonResponse.isSuccess()) {
				crearInvitacion.setEstado(invitacionOriginal.get().getEstado());
				crearInvitacion.setRutOrigen(invitacionOriginal.get().getUsuario2().getRut());
				crearInvitacion.setRutDestino(invitacionOriginal.get().getUsuario1().getRut());
				crearInvitacion.setFecha(invitacionOriginal.get().getFecha());
				
				// Se restaura el registro anterior.
				this.crearInvitacion(crearInvitacion);
			}
			
		}
		else {
			commonResponse.setMessage(MSG_ERR_2_NOEXISTE);
			commonResponse.setErrorCode(2);
			commonResponse.setSuccess(false);
		}
		
		return commonResponse;
	}
	
	public CommonResponse eliminarInvitacion(EliminarInvitacionReq eliminarInvitacion) {
		CommonResponse commonResponse = new CommonResponse();
		
		invitacionRepo.deleteById(eliminarInvitacion.getId());
		
		// Se busca el registro para validar eliminacion
		if(invitacionRepo.existsById(eliminarInvitacion.getId())) {
			commonResponse.setMessage(MSG_ERR_TECNICO);
			commonResponse.setErrorCode(2);
			commonResponse.setSuccess(false);
		}
		else {
			commonResponse.setMessage(MSG_SUCC);
			commonResponse.setErrorCode(0);
			commonResponse.setSuccess(true);
		}
		
		return commonResponse;
	}
	
	public CompartirInvitacionRes compartirInvitacion(CompartirInvitacionReq compartirInvitacion) {
		return null;
	}
}
