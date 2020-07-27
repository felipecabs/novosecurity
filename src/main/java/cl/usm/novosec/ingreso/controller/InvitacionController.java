package cl.usm.novosec.ingreso.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cl.usm.novosec.ingreso.services.InvitacionService;
import cl.usm.novosec.ingreso.signature.CommonResponse;
import cl.usm.novosec.ingreso.signature.CompartirInvitacionRes;
import cl.usm.novosec.ingreso.signature.CrearInvitacionReq;
import cl.usm.novosec.ingreso.signature.EditarInvitacionReq;
import cl.usm.novosec.ingreso.signature.EliminarInvitacionReq;
import cl.usm.novosec.ingreso.signature.ListarInvitadosRes;

@RestController
public class InvitacionController {
	
	final static Logger logger = LoggerFactory.getLogger(InvitacionController.class);
	
	@Autowired
	InvitacionService invitacionService;
	
	@GetMapping(path = "/invitaciones", produces = "application/json")
	public ListarInvitadosRes listarInvitados() {
		return invitacionService.listarInvitados(null);
	}
	
	@PostMapping(path = "/invitacion", produces = "application/json")
	public CommonResponse crearInvitacion(@RequestBody CrearInvitacionReq crearInvitacion) {
		logger.info("Se ejecuta crear invitacion");
		return invitacionService.crearInvitacion(crearInvitacion);
	}
	
	@PutMapping(path = "/invitacion", produces = "application/json")
	public CommonResponse editarInvitacion(@RequestBody EditarInvitacionReq editarInvitacion) {
		logger.info("Se ejecuta editar invitacion");
		return invitacionService.editarInvitacion(editarInvitacion);
	}
	
	@DeleteMapping(path = "/invitacion", produces = "application/json")
	public CommonResponse eliminarInvitacion(EliminarInvitacionReq eliminarInvitacion) {
		logger.info("Se ejecuta eliminar invitacion");
		return invitacionService.eliminarInvitacion(eliminarInvitacion);
	}
	
	@GetMapping(path = "/invitacion/{id}/compartir", produces = "application/json")
	public CompartirInvitacionRes compartirInvitacion(@PathVariable("id") int idInvitacion) {
		return null;
	}
}
