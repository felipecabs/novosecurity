package cl.usm.novosec.ingreso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cl.usm.novosec.ingreso.services.IngresoService;
import cl.usm.novosec.ingreso.signature.AutorizarIngresoReq;
import cl.usm.novosec.ingreso.signature.CommonResponse;
import cl.usm.novosec.ingreso.signature.CrearIngresoReq;
import cl.usm.novosec.ingreso.signature.EditarIngresoReq;
import cl.usm.novosec.ingreso.signature.ListarIngresosReq;

@RestController
public class IngresoController {
	
	@Autowired
	IngresoService ingresoService;
	
	@PostMapping(path="/ingreso/autorizar", produces = "application/json")
	public CommonResponse autorizarIngreso(@RequestBody AutorizarIngresoReq autorizarIngreso) {
		return ingresoService.autorizarIngreso(autorizarIngreso);
	}
	
	@PostMapping(path="/ingreso", produces="application/json")
	public CommonResponse crearIngreso(@RequestBody CrearIngresoReq crearIngreso) {
		return ingresoService.crearIngreso(crearIngreso);
	}
	
	@PutMapping(path="/ingreso", produces = "application/json")
	public CommonResponse editarIngreso(@RequestBody EditarIngresoReq editarIngreso) {
		return ingresoService.editarIngreso(editarIngreso);
	}
	
	@GetMapping(path="/ingresos", produces = "application/json")
	public ListarIngresosReq listarIngresos() {
		return ingresoService.listarIngresos();
	}
}
