package cl.usm.novosec.ingreso.services;

import java.util.Iterator;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.usm.novosec.ingreso.dao.Ingreso;
import cl.usm.novosec.ingreso.dao.IngresoPK;
import cl.usm.novosec.ingreso.dao.Invitacion;
import cl.usm.novosec.ingreso.dao.Usuario;
import cl.usm.novosec.ingreso.dto.IngresoDTO;
import cl.usm.novosec.ingreso.repository.IngresoRepository;
import cl.usm.novosec.ingreso.repository.InvitacionRepository;
import cl.usm.novosec.ingreso.repository.UsuarioRepository;
import cl.usm.novosec.ingreso.signature.AutorizarIngresoReq;
import cl.usm.novosec.ingreso.signature.CommonResponse;
import cl.usm.novosec.ingreso.signature.CrearIngresoReq;
import cl.usm.novosec.ingreso.signature.EditarIngresoReq;
import cl.usm.novosec.ingreso.signature.ListarIngresosReq;

@Service
public class IngresoService {
	
	final static String MSG_ERR_1_DUPLICIDAD = "No puede crear una invitación a sí mismo";
	final static String MSG_ERR_2_NOEXISTE = "El registro a editar no existe";
	final static String MSG_ERR_3_NOEXISTE = "El registro a autorizar no existe";
	final static String MSG_ERR_4_NOEXISTE = "El usuario no existe";
	final static String MSG_ERR_TECNICO = "No se pudo crear/modificar el registro, contacte al administrador del sistema";
	final static String MSG_SUCC= "El registro fue creado/editado exitosamente";
	
	final static String STR_AUTORIZADO = "AUTORIZADO";
	final static String STR_CREADO = "CREADO";
	final static String STR_INVITACION = "INVITACION";
	final static String STR_COMENTARIOS = "Invitacion creada automaticamente via autorizacion";
	
	private Logger logger = LoggerFactory.getLogger(IngresoService.class);
	
	@Autowired
	InvitacionRepository invitacionRepo;
	
	@Autowired
	IngresoRepository ingresoRepo;
	
	@Autowired
	UsuarioRepository usuarioRepo;
	
	public CommonResponse autorizarIngreso(AutorizarIngresoReq autorizarIngreso) {
		CommonResponse commonResponse = new CommonResponse();
		Optional<Invitacion> invitacion = invitacionRepo.findById(autorizarIngreso.getIdInvitacion());
		
		if(invitacion.isPresent()) {
			
			logger.debug(String.format("La invitacion %d fue encontrada",autorizarIngreso.getIdInvitacion()));
			
			Ingreso ingreso = new Ingreso();
			IngresoPK id = new IngresoPK();
			id.setUsuarioRut(invitacion.get().getUsuario1().getRut());
			
			ingreso.setId(id);
			ingreso.setEstado(STR_CREADO);
			ingreso.setTipo(STR_INVITACION);
			ingreso.setUsuario(invitacion.get().getUsuario1());
			ingreso.setComentarios(STR_COMENTARIOS);
			
			Ingreso ingresoNuevo = ingresoRepo.save(ingreso);
			
			if(ingresoNuevo != null) {
				commonResponse.setMessage(MSG_SUCC);
				commonResponse.setSuccess(true);
				commonResponse.setErrorCode(0);
			}
			else {
				commonResponse.setMessage(MSG_ERR_TECNICO);
				commonResponse.setSuccess(false);
				commonResponse.setErrorCode(-1);
			}
			
		}
		else {
			logger.debug(String.format("La invitacion %d no fue encontrada",autorizarIngreso.getIdInvitacion()));
			commonResponse.setMessage(MSG_ERR_3_NOEXISTE);
			commonResponse.setSuccess(false);
			commonResponse.setErrorCode(3);
		}
		
		return commonResponse;
	}
	
	public CommonResponse crearIngreso(CrearIngresoReq crearIngreso) {
		CommonResponse commonResponse = new CommonResponse();
		Optional<Usuario> usuario = usuarioRepo.findById(crearIngreso.getRutUsuario());
		
		if(usuario.isPresent()) {
			
			Ingreso ingreso = new Ingreso();
			IngresoPK id = new IngresoPK();
			id.setUsuarioRut(crearIngreso.getRutUsuario());
			
			ingreso.setId(id);
			ingreso.setEstado(crearIngreso.getEstado());
			ingreso.setTipo(crearIngreso.getTipo());
			ingreso.setUsuario(usuario.get());
			ingreso.setComentarios(crearIngreso.getComentarios());
			
			Ingreso ingresoNuevo = ingresoRepo.save(ingreso);
			
			if(ingresoNuevo != null) {
				commonResponse.setMessage(MSG_SUCC);
				commonResponse.setSuccess(true);
				commonResponse.setErrorCode(0);
			}
			else {
				commonResponse.setMessage(MSG_ERR_TECNICO);
				commonResponse.setSuccess(false);
				commonResponse.setErrorCode(-1);
			}
			
		}
		else {
			commonResponse.setMessage(MSG_ERR_4_NOEXISTE);
			commonResponse.setSuccess(false);
			commonResponse.setErrorCode(4);
		}
		
		return commonResponse;
	}
	
	public CommonResponse editarIngreso(EditarIngresoReq editarIngreso) {
		CommonResponse commonResponse = new CommonResponse();
		Optional<Usuario> usuario = usuarioRepo.findById(editarIngreso.getRutUsuario());
		Optional<Ingreso> ingresoOriginal = ingresoRepo.findById(new IngresoPK(editarIngreso.getId(), editarIngreso.getRutUsuario())); 
		Ingreso ingresoEditado;
		
		if(usuario.isPresent() && ingresoOriginal.isPresent()) {
			Ingreso ingreso = new Ingreso();
			ingreso.setId(new IngresoPK(editarIngreso.getId(), editarIngreso.getRutUsuario()));
			ingreso.setTipo(editarIngreso.getTipo());
			ingreso.setEstado(editarIngreso.getEstado());
			ingreso.setEstacionamientoVisita(editarIngreso.getIdEstacionamiento());
			ingreso.setUsuario(usuario.get());
			ingreso.setComentarios(editarIngreso.getComentarios());
			ingreso.setFecha(ingresoOriginal.get().getFecha());
			
			ingresoEditado = ingresoRepo.save(ingreso);
			
			if(ingresoEditado != null) {
				commonResponse.setMessage(MSG_SUCC);
				commonResponse.setSuccess(true);
				commonResponse.setErrorCode(0);
			}
			else {
				commonResponse.setMessage(MSG_ERR_TECNICO);
				commonResponse.setSuccess(false);
				commonResponse.setErrorCode(-1);
			}
			
		}
		else {
			commonResponse.setMessage(MSG_ERR_4_NOEXISTE);
			commonResponse.setSuccess(false);
			commonResponse.setErrorCode(4);
		}
		
		return commonResponse;
	}
	
	public ListarIngresosReq listarIngresos() {
		ListarIngresosReq listarIngresosReq = new ListarIngresosReq();
		Iterable<Ingreso> ingresoIt = ingresoRepo.findAll();		
		Iterator<Ingreso> it = ingresoIt.iterator();
		IngresoDTO ingresoDTO = new IngresoDTO();
		
		while(it.hasNext()) {
			listarIngresosReq.getIngresos().add(ingresoDTO.castDaoToVo(it.next()));
		}
		
		return listarIngresosReq;
	}
}
